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
public class SingleNode {

    private char data;
    private SingleNode next;
    
    public SingleNode() {
        
    }
    
    public SingleNode(char data, SingleNode next) {
        this.data = data;
        this.next = next;
    }
    
    /**
    *The character 'data' in the current node will be returned. 
    *Time Complexity: O(1)
     * @return char 
     */
    public char getData() {
        return data;
    }
    
    /**
    *The character 'data' will be assigned to 'data' of current node.
    *Time Complexity: O(1)    
     * @param data 
     */
    public void setData(char data) {
        this.data = data;
    }
    
    /**
    *The next node will be returned.
    *Time Complexity: O(1)
     * @return DoubleNode 
     */
    public SingleNode getNext() {
        return next;
    }
    
    /**
    *The next node will be set to 'next'.
    *Time Complexity: O(1)
     * @param next 
     */
    public void setNext(SingleNode next) {
        this.next = next;
    }
}