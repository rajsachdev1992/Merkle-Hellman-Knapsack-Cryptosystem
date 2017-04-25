package doublylinkedlist;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raj92
 */
public class DoubleNode {
    
    private DoubleNode p;
    private char ch;
    private DoubleNode n;
    
    public DoubleNode() {
        //Default constructor
    }
    
    public DoubleNode(DoubleNode p, char ch, DoubleNode n) {
        this.p = p;
        this.ch = ch;
        this.n = n;
    }
    
    /**
    *The previous node will be returned.
    *Time Complexity: O(1)
     * @return DoubleNode 
     */
    public DoubleNode getPrev() {
        return this.p;
    }
    
    /**
    *The previous node will be set to prev.
    *Time Complexity: O(1)
    
     * @param prev 
     */
    public void setPrev(DoubleNode prev) {
        this.p = prev;
    }
    
    /**
    *The next node will be returned.
    *Time Complexity: O(1)
     * @return DoubleNode 
     */
    public DoubleNode getNext() {
        return this.n;
    }
    
    /**
    *The next node will be set to 'next'.
    *Time Complexity: O(1)
     * @param next 
     */
    public void setNext(DoubleNode next) {
        this.n = next;
    }
    
    /**
    *The character 'ch' in the current node will be returned. 
    *Time Complexity: O(1)
     * @return char 
     */
    public char getC() {
        return ch;
    }
    
    /**
    *The character 'c' will be assigned to 'ch' of current node.
    *Time Complexity: O(1)    
     * @param c 
     */
    public void setC(char c) {
        this.ch = c;
    }
    
    /**
    * The character 'ch' of current node will be returned as a String.
    * Time Complexity: O(1)
     * @return String 
     */
    @Override
    public String toString() {
        return String.valueOf(ch);
    }
}
