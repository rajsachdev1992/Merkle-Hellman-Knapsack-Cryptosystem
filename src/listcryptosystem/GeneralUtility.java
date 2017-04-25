/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listcryptosystem;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Raj92
 */
public class GeneralUtility {
    
    public static final int RANDOM_BOUND =5;
    
    /**
    *Pre-condition: n > 1.
    *Post-condition: A super increasing sequence of size 'n' will be returned as a linked list.
    *Time Complexity: O(n)
     * @param n
     * @return DoublyLinkedListInt
     */
    public static DoublyLinkedListInt createSuperIncreasingSequence(int n) {
        //
        BigInteger nextNumber = new BigInteger(String.valueOf(new Random().nextInt(RANDOM_BOUND)+1));
        BigInteger sum = new BigInteger(nextNumber.toString());
        DoublyLinkedListInt sequence = new DoublyLinkedListInt();
        for(int i=0;i<n;i++) {
            sequence.addIntAtEnd(sum);
            nextNumber = sum.add(new BigInteger(String.valueOf(new Random().nextInt(RANDOM_BOUND) + 1)));
            sum = sum.add(nextNumber);
            //System.out.println(sum);
        }
        return sequence;
    }
    
    /**
    *Pre-condition: the size of list should be greater than 1.
    *Post-condition: A BigInteger greater than the greatest number in the list is returned.
    *Time Complexity: O(1)
     * @param list
     * @return BigInteger
     */
    public static BigInteger generateQ(DoublyLinkedListInt list) {
        BigInteger random = new BigInteger(String.valueOf(new Random().nextInt(RANDOM_BOUND)+1));
        BigInteger q = list.getSum().add(random);
        return q;
    }
    
    /**
    *Pre-condition: No pre-condition.
    *Post-condition: A BigInteger which is coprime with 'q' is returned.
    *Time Complexity: O(1)
     * @param q
     * @return BigInteger
     */
    public static BigInteger generateR(BigInteger q) {
        BigInteger r = q.subtract(BigInteger.ONE);
        return r;
    }
    
    /**
    *Pre-condition: the size of list should be greater than 1.
    *Post-condition: A BigInteger greater than the greatest number in the list is returned.
    *Time Complexity: O(n), where n is the size of list w.
     * @param w
     * @param q
     * @param r
     * @return DoublyLinkedListInt
     */
    public static DoublyLinkedListInt generatePublicKeySequence(DoublyLinkedListInt w, 
            BigInteger q, BigInteger r) {
        
        ListNode cur = w.getHead();
        BigInteger x;
        DoublyLinkedListInt publicKeyList = new DoublyLinkedListInt();
        while(cur!=null) {
            x = cur.getVal();
            x = x.multiply(r);
            x = x.mod(q);
            publicKeyList.addIntAtEnd(x);
            cur = cur.getNext();
        }
        return publicKeyList;
    }
    
    /**
    * Pre-condition: 's' should not be null.
    * Post-condition: A binary code representing the ASCII code of 's' will be returned.
    * Time Complexity: O(n).
     * @param s
     * @return String
     */
    public static String convertStringToBinary(String s) {
        StringBuilder binaryString = new StringBuilder();
        byte[] strBytes = s.getBytes();
        int x;
        for(byte b : strBytes) {
            x = b;
            for(int i=0; i<8; i++) {
                binaryString.append((x & 128) == 0 ? 0 : 1);
                x <<= 1;
            }
        }
        return binaryString.toString();
    }
    
    /**
    * Pre-condition: the length of 'b' and binaryString should be equal.
    * Post-condition: The cipher-text is returned as a BigInteger.
    * Time Complexity: O(n).
     * @param b
     * @param binaryString 
     * @return BigInteger
     */
    public static BigInteger calculateBetaSum(DoublyLinkedListInt b, String binaryString) {
        BigInteger sum = BigInteger.ZERO;
        ListNode cur = b.getHead();
        for(int i=0;i<binaryString.length();i++) {
            if(binaryString.charAt(i) == '1') {
                sum = sum.add(cur.getVal());
            }
            cur = cur.getNext();
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
    public static String buildDecryptedSequence(BigInteger decryptionSum, DoublyLinkedListInt w) {
        
        StringBuilder binarySequenceBuilder = new StringBuilder("");
        ListNode cur = w.getTail();
        while(cur!=null) {
            if(decryptionSum.compareTo(cur.getVal()) < 0) {
                binarySequenceBuilder.append("0");
            } else if(decryptionSum.compareTo(BigInteger.ZERO) > 0){
                binarySequenceBuilder.append("1");
                decryptionSum = decryptionSum.subtract(cur.getVal());
            } else {
                binarySequenceBuilder.append("0");
            }
            cur = cur.getPrev();
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
        for(int i=0;i<decryptedSequence.length();i+=8) {
            int charCode = Integer.parseInt(decryptedSequence.substring(i, i+8), 2);
            finalResult.append(new Character((char)charCode));
        }
        return finalResult.toString();
        
    }    
}
