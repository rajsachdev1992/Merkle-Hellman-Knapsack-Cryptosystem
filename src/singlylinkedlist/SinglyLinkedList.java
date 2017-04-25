/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;


/**
 *
 * @author Raj92
 */
public class SinglyLinkedList {
    
    SingleNode head;
    int size;
    
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    
    /**
     * Pre-condition: There should be no loop in the list.
     * Post-condition: The character 'c' will be added to the end of the list.
     * Time Complexity: O(n)
     * @param c 
     */
    public void insertChar(char c) {
        SingleNode tmp = new SingleNode(c, null);
        if(head == null) {
            head = tmp;
        } else {
            SingleNode cur = head;
            while(cur.getNext() != null) {
                cur=cur.getNext();
            }
            cur.setNext(tmp);
        }
        size++;
    }
    
    /**
     * Pre-condition: The list should not be empty
     * Post-condition: Each element of the list is printed starting from head.
     * Time Complexity: O(n)
     * Prints the linked list.
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        if(head == null) {
            result.append("List is empty");
        } else {
            SingleNode cur = head;
            while(cur!=null) {
                result.append(cur.getData());
                cur = cur.getNext();
            }
        }
        return result.toString();
    }
    
    /**
     * Pre-condition: s should not be null.
     * Post-condition: The string s is converted to a linked list with each character
     * stored in a node.
     * @param s 
     */
    public void buildListFromString(String s) {
        if(s!=null && !s.equals("")) {
            for(int i=0;i<s.length();i++) {
                insertChar(s.charAt(i));
            }
        }
    }
    
    /**
     * Pre-condition: list1 and list2 should not be null.
     * Post-condition: A concatenated list of list1 and list2 is returned.
     * @param list1
     * @param list2
     * @return SinglyLinkedList
     */
    public static SinglyLinkedList concatLists(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList result = new SinglyLinkedList();
        SingleNode cur = list1.head;
        while(cur!=null) {
            result.insertChar(cur.getData());
            cur = cur.getNext();
        }
        cur = list2.head;
        while(cur!=null) {
            result.insertChar(cur.getData());
            cur = cur.getNext();
        }
        return result;
    }
    
}
