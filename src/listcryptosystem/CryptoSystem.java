/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listcryptosystem;

import java.math.BigInteger;

/**
 *
 * @author Raj92
 */
public class CryptoSystem {
    //public key
    private DoublyLinkedListInt b;
    //private key
    private DoublyLinkedListInt w;
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
        w = GeneralUtility.createSuperIncreasingSequence(s.length()*8);
        q = GeneralUtility.generateQ(w);
        r = GeneralUtility.generateR(q);
        b = GeneralUtility.generatePublicKeySequence(w, q, r);
        String binaryString = GeneralUtility.convertStringToBinary(s);
        BigInteger c = GeneralUtility.calculateBetaSum(b, binaryString);
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
        BigInteger dSum = GeneralUtility.calculateDecryptionSum(betaSum, q, r);
        String binarySequence = GeneralUtility.buildDecryptedSequence(dSum, w);
        return GeneralUtility.convertDycryptedSequenceToString(binarySequence);
    } 
}
