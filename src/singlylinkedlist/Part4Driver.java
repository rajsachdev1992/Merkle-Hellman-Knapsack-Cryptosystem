/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

import java.util.Scanner;
import static singlylinkedlist.SinglyLinkedList.concatLists;

/**
 *
 * @author Raj92
 */
public class Part4Driver {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first String:");
        String s1 = in.nextLine();
        System.out.println("Enter the second String");
        String s2 = in.nextLine();
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        list1.buildListFromString(s1);
        list2.buildListFromString(s2);
        SinglyLinkedList list3 = concatLists(list1, list2);
        System.out.println("The result String is:");
        System.out.println(list3);
    }
}
