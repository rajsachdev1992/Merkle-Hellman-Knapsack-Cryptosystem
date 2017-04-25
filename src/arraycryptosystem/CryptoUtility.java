/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraycryptosystem;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Raj92
 */
public class CryptoUtility {

    public static final int RANDOM_BOUND = 5;
    private static BigInteger wSum = BigInteger.ZERO;
    
    /**
    * Pre-condition: n > 1.
    * Post-condition: A super increasing sequence of size n will be returned.
    * Time Complexity: O(n).
     * @param n
     * @return BigInteger[]
     */
    public static BigInteger[] createSuperIncreasingSequence(int n) {
        BigInteger nextNumber = new BigInteger(String.valueOf(new Random().nextInt(RANDOM_BOUND) + 1));
        wSum = new BigInteger(nextNumber.toString());
        BigInteger[] sequence = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = wSum;
            nextNumber = wSum.add(new BigInteger(String.valueOf(new Random().nextInt(RANDOM_BOUND) + 1)));
            wSum = wSum.add(nextNumber);
            //System.out.println(sum);
        }
        return sequence;
    }
    
    /**
    * Pre-condition: wSum > 0.
    * Post-condition: 'q' of private key is returned.
    * Time Complexity: O(1).
     * @return BigInteger
     */
    public static BigInteger generateQ() {
        BigInteger random = new BigInteger(String.valueOf(new Random().nextInt(RANDOM_BOUND) + 1));
        BigInteger q = wSum.add(random);
        return q;
    }
    
    /**
     * Pre-condition: q should not be null.
     * Post-condition: 'r' of the private key is generated and returned.
     * Time Complexity: O(1).
     * @param q
     * @return BigInteger
     */
    public static BigInteger generateR(BigInteger q) {
        BigInteger r = q.subtract(BigInteger.ONE);
        return r;
    }
    
    /**
     * Pre-condition: w, q, or r should not be null.
     * Post-condition: The public key sequence is generated and returned.
     * Time Complexity: O(n).
     * @param w
     * @param q
     * @param r
     * @return BigInteger[]
     */
    public static BigInteger[] generatePublicKeySequence(BigInteger[] w,
            BigInteger q, BigInteger r) {

        BigInteger x;
        BigInteger[] publicKeyList = new BigInteger[w.length];
        for(int i=0; i < w.length ;i++) {
            x = w[i];
            x = x.multiply(r);
            x = x.mod(q);
            publicKeyList[i] = x;
        }
        return publicKeyList;
    }
    
    /**
     * Pre-condition: s should not be null.
     * Post-condition: A binary sequence of the input string is generated.
     * Time Complexity: O(n).
     * @param s
     * @return String
     */
    public static String convertStringToBinary(String s) {
        StringBuilder binaryString = new StringBuilder();
        byte[] strBytes = s.getBytes();
        int x = 0;
        for (byte b : strBytes) {
            x = b;
            for (int i = 0; i < 8; i++) {
                binaryString.append((x & 128) == 0 ? 0 : 1);
                x <<= 1;
            }
        }
        return binaryString.toString();
    }
    
    /**
     * Pre-condition: b or binaryString should not be null.
     * Post-condition: The cipher-text is returned as a BigInteger.
     * Time Complexity: O(n).
     * @param b
     * @param binaryString
     * @return BigInteger
     */
    public static BigInteger calculateBetaSum(BigInteger[] b, String binaryString) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                sum = sum.add(b[i]);
            }
        }
        return sum;
    }
    
    /**
    * Pre-condition: BetaSum, q, or r should not be null.
    * Post-condition: The decryption-sum is returned.
    * Time Complexity: O(1).
     * @param betaSum
     * @param q
     * @param r
     * @return BigInteger
     */
    public static BigInteger calculateDecryptionSum(BigInteger betaSum, BigInteger q, BigInteger r) {

        BigInteger result = r.modInverse(q);
        result = result.multiply(betaSum);
        result = result.mod(q);
        return result;
    }
    
    /**
    * Pre-condition: DecryptionSum or w should not be null.
    * Post-condition: The decrypted binary ASCII string is returned.
    * Time Complexity: O(n).
     * @param decryptionSum 
     * @param w
     * @return String
     */
    public static String buildDecryptedSequence(BigInteger decryptionSum, BigInteger[] w) {

        StringBuilder binarySequenceBuilder = new StringBuilder("");
        for(int i = w.length - 1; i>=0; i-- ) {
            if (decryptionSum.compareTo(w[i]) < 0) {
                binarySequenceBuilder.append("0");
            } else if (decryptionSum.compareTo(BigInteger.ZERO) > 0) {
                binarySequenceBuilder.append("1");
                decryptionSum = decryptionSum.subtract(w[i]);
            } else {
                binarySequenceBuilder.append("0");
            }
        }

        return binarySequenceBuilder.reverse().toString();
    }
    
    /**
    * Pre-condition: DecryptedSequence should not be null.
    * Post-condition: The decrypted String is returned.
    * Time Complexity: O(1).
     * @param decryptedSequence
     * @return String
     */
    public static String convertDycryptedSequenceToString(String decryptedSequence) {

        StringBuilder finalResult = new StringBuilder("");
        for (int i = 0; i < decryptedSequence.length(); i += 8) {
            int charCode = Integer.parseInt(decryptedSequence.substring(i, i + 8), 2);
            finalResult.append(new Character((char) charCode));
        }
        return finalResult.toString();

    }
}
