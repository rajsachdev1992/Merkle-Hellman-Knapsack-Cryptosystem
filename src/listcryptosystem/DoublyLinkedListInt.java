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
public class DoublyLinkedListInt {
    
    private ListNode head;
    private ListNode tail;
    private int size;
    private BigInteger sum;
    
    /**
    *Pre-condition: There should be no loop in the list.
    *Post-condition: The BigInteger 'number' will be added to the end of the list.
    *Time Complexity: O(1)
     * @param number 
     */
    public void addIntAtEnd(BigInteger number) {
        ListNode tmp = new ListNode(null, number, null);
        if(head == null) {
            head = tmp;
            tail = head;
        } else {
            tail.setNext(tmp);
            tmp.setNext(null);
            tmp.setPrev(tail);
            tail = tmp;
        }
        size++;
        if(sum == null) {
            sum = BigInteger.ZERO;
        }
        sum = sum.add(number);
    }
    
    /**
    *Pre-condition: The list should not be empty
    *Post-condition: Each element of the list is printed starting from head to tail.
    *Time Complexity: O(n)

     * Prints the linked list.
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        if(size!=0) {
            ListNode cur = head;
            while(cur!=null) {
                
                result.append(cur.getVal().toString());
                result.append(" ");
                cur = cur.getNext();
            }
        } else {
              result.append("List is empty");
        }
        return result.toString();
    }
    
    /**
    *head node of the list is returned.
    *Time Complexity: O(1)
     * @return ListNode
     */
    public ListNode getHead() {
        return head;
    }
    
    /**
     * head node is set to 'head'.
     * Time Complexity: O(1)
     * @param head 
     */
    public void setHead(ListNode head) {
        this.head = head;
    }
    
    /**
     * Head node is set to 'head'.
     * Time Complexity: O(1)
     * @return ListNode 
     */
    public ListNode getTail() {
        return tail;
    }
    
    /**
     * Tail node is set to 'tail'.
     * Time Complexity: O(1)
     * @param tail 
     */
    public void setTail(ListNode tail) {
        this.tail = tail;
    }
    
    /**
     * The size of the list is returned.
     * Time Complexity: O(1)
     * @return integer 
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Sum of all BigIntegers in the list is returned.
     * Time Complexity: O(1)
     * @return BigInteger 
     */
    public BigInteger getSum() {
        return sum;
    }
}
