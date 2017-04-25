/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraycryptosystem;

import java.math.BigInteger;

/**
 *
 * @author Raj92
 */
public class CryptoSystemArray {
    
    private BigInteger[] b;
    //private key
    private BigInteger[] w;
    private BigInteger q;
    private BigInteger r;
    
    /**
    * Pre-condition: The string s should not be null.
    * Post-condition: The cipher text is returned as a string.
    * Time Complexity: O(n).
     * @param s
     * @return String
     */
    public String Encrypt(String s) {
        w = CryptoUtility.createSuperIncreasingSequence(s.length()*8);
        q = CryptoUtility.generateQ();
        r = CryptoUtility.generateR(q);
        b = CryptoUtility.generatePublicKeySequence(w, q, r);
        String binaryString = CryptoUtility.convertStringToBinary(s);
        BigInteger c = CryptoUtility.calculateBetaSum(b, binaryString);
        return c.toString();
    }
    
    /**
    * Pre-condition: c should not be null.
    * Post-condition: The decryption-sum is returned.
    * Time Complexity: O(n).
     * @param c
     * @return String
     */
    public String Decrypt(String c) {
        BigInteger betaSum = new BigInteger(c);
        BigInteger dSum = CryptoUtility.calculateDecryptionSum(betaSum, q, r);
        String binarySequence = CryptoUtility.buildDecryptedSequence(dSum, w);
        return CryptoUtility.convertDycryptedSequenceToString(binarySequence);
    }
    
}
