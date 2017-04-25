/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraycryptosystem;

import java.util.Scanner;

/**
 *
 * @author Raj92
 */
public class CryptoArrayDriver {
    
    public static final int MAX_LENGTH = 80;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        CryptoSystemArray cs = new CryptoSystemArray();
        System.out.println("Enter a string and I will encrypt it as single large integer.");
        String s = in.nextLine();
        while(s == null || s.equals("") || s.length() > MAX_LENGTH) {
            if(s==null || s.equals("")) {
                System.out.println("Blank string entered!! Please enter a valid string");
            } else {
                System.out.println("String entered is too long, enter again!");
            }
            s = in.nextLine();
        }
        System.out.println("Clear text: ");
        System.out.println(s);
        System.out.println("Number of clear text bytes = "+s.length());
        String c = cs.Encrypt(s);
        System.out.println("\""+s+"\" is encrypted as: ");
        System.out.println(c);
        String result = cs.Decrypt(c);
        System.out.println("Result of Decryption: ");
        System.out.println(result);
    }
    
}
