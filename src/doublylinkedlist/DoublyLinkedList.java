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
public class DoublyLinkedList {
    
    DoubleNode head;
    DoubleNode tail;
    int size;
    
    
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Pre-condition: There should be no loop in the list.
     * Post-condition: The character 'c' will be added to the end of the list.
     * Time Complexity: O(1)
     * @param c 
     */
    public void addCharAtEnd(char c) {
        DoubleNode tmp = new DoubleNode(null, c, null);
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
    }
    
    /**
    *Pre-condition: There should be no loop in the list.
    *Post-condition: The character 'c' will be added to the beginning of the list.
    *Time Complexity: O(1)
     * @param c 
     */
    public void addCharAtFront(char c) {
        DoubleNode tmp = new DoubleNode(null, c, null);
        if(head == null) {
            head = tmp;
            tail = head;
        } else {
            tail.setNext(tmp);
            tmp.setPrev(tail);
            tail = tmp;
        }
        size++;
    }
    
    /**
    *The size of the list will be returned.
    *Time Complexity: O(1)
    
     * @return c 
     */
    public int countNodes() {
        return size;
    }
    
    /**
    *Pre-condition: The list should not be empty, and the character c should exust in the list.
    *Post-condition: The first occurance of 'c' will be deleted, if it exists.
    *Time Complexity: O(n)
     * Deletes the first occurence of the character c. 
     * @param c
     * @return boolean 
     */
    public boolean deleteChar(char c) {
        DoubleNode cur = head;
        boolean isFound = false;
        if(cur == null) {
            return false;
        }
        while(cur != null) {
            if(cur.getC() == c) {
                isFound = true;
                break;
            }
            cur = cur.getNext();
        }
        
        if(isFound) {
            if(size == 1) {
                head = null;
                tail = null;
            } else {
                if(cur == head) {
                    cur = cur.getNext();
                    cur.setPrev(null);
                    head = cur;
                } else if(cur == tail) {
                    cur = cur.getPrev();
                    cur.setNext(null);
                    tail = cur;
                } else {
                    DoubleNode prev = cur.getPrev();
                    DoubleNode next = cur.getNext();
                    prev.setNext(next);
                    next.setPrev(prev);
                }
            }
            size--;
        }
        return isFound;
    }
    
    /**
     * True will be returned if the list is empty, otherwise false.
     * Time Complexity: O(1)
     * Checks if the list is empty.
     * @return boolean
     */
    public boolean isEmpty() {
        Boolean isEmptyFlag = false;
        if(size == 0) {
            isEmptyFlag = true;
        }
        return isEmptyFlag;
    }
    
    /**
    * Pre-condition: List should not be empty. 
    * Post-condition: The element at the end of the list will be removed.
    * Time Complexity: O(1)
     * Removes the character from the end of the linked list.
     * @return char
     */
    public char removeCharAtEnd() {
        char deleted;
        switch (size) {
            case 0:
                deleted = 0;
                break;
            case 1:
                deleted = head.getC();
                head = null;
                tail = null;
                break;
            default:
                DoubleNode prev = tail.getPrev();
                deleted = tail.getC();
                prev.setNext(null);
                tail = prev;
                break;
        }
        if(size != 0) {
           size--; 
        } 
        return deleted;
    }
    
    /**
    * Pre-condition: List should not be empty
    * Post-condition: The element at the start of the list will be removed.
    * Time Complexity: O(1)
     * Removes the character from the front of the linked list.
     * @return char 
     */
    public char removeCharFromFront() {
        char deleted;
        switch (size) {
            case 0:
                deleted = 0;
                break;
            case 1:
                deleted = head.getC();
                head = null;
                tail = null;
                break;
            default:
                DoubleNode next = head.getNext();
                deleted = head.getC();
                next.setPrev(null);
                head = next;
                break;
        }
        if(size != 0) {
           size--; 
        } 
        return deleted;
    }
    
    /**
    * Pre-condition: List Size > 1
    * Post-condition: The list will be reversed
    * Time Complexity: O(n)
     * This method reverses the list of type DoubleLinkedList
     */
    public void reverse() {
        DoubleNode cur = head;
        DoubleNode tmp = null;
        while(cur != null) {
            cur.setPrev(cur.getNext());
            cur.setNext(tmp);
            tmp = cur;
            cur = cur.getPrev();
        }
        cur = head;
        head = tail;
        tail = cur;
    }
    
    /**
     * Pre-condition: The list should not be empty
     * Post-condition: Each element of the list is printed starting from head to tail.
     * Time Complexity: O(n)
     * Prints the linked list.
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        if(size!=0) {
            DoubleNode cur = head;
            while(cur!=null) {
                
                result.append(cur.getC());
                result.append(" ");
                cur = cur.getNext();
            }
        } else {
              result.append("List is empty");
        }
        return result.toString();
    }   
}
