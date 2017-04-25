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
public class ListNode {
    
    private ListNode prev;
    private BigInteger data ;
    private ListNode next;
    
    public ListNode() {
        
    }
    
    public ListNode(ListNode prev, BigInteger data, ListNode next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
    
    /**
    *The previous node will be returned.
    *Time Complexity: O(1)
    
     * @return ListNode 
     */
    public ListNode getPrev() {
        return this.prev;
    }
    
    /**
    *The previous node will be set to prev.
    *Time Complexity: O(1)
    
     * @param prev 
     */
    public void setPrev(ListNode prev) {
        this.prev = prev;
    }
    
    /**
    *The next node will be returned.
    *Time Complexity: O(1)
    
     * @return ListNode 
     */
    public ListNode getNext() {
        return this.next;
    }
    
    /**
    *The next node will be set to 'next'.
    *Time Complexity: O(1)
     * @param next 
     */
    public void setNext(ListNode next) {
        this.next = next;
    }
    
    /**
    *The BigInteger 'data' in the current node will be returned. 
    *Time Complexity: O(1)
     * @return BigInteger 
     */
    public BigInteger getVal() {
        return this.data;
    }
    
    /**
    *The BigInteger 'val' will be assigned to 'data' of current node.
    *Time Complexity: O(1)
    
     * @param val 
     */
    public void setVal(BigInteger val) {
        this.data = val;
    }
}
