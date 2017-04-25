/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;

/**
 *
 * @author Raj92
 */
public class Part1Driver {
    
    public static void main(String a[]) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addCharAtEnd('H');
		list.addCharAtEnd('e');
		list.addCharAtEnd('l');
		list.addCharAtEnd('l');
		list.addCharAtEnd('o');
		System.out.println(list);
		System.out.println("Deleting l");
		list.deleteChar('l');
		System.out.println(list);
		System.out.println("Deleting H");
		list.deleteChar('H');
		System.out.println(list);
		System.out.println("Deleting o");
		list.deleteChar('o');
		System.out.println(list);
		System.out.println("Deleting e");
		list.deleteChar('e');
		System.out.println(list);
		System.out.println("Deleting l");
		list.deleteChar('l');
		System.out.println(list);
		list.addCharAtFront('o');
		list.addCharAtFront('l');
		list.addCharAtFront('l');
		list.addCharAtFront('e');
		list.addCharAtFront('H');
		System.out.println(list);
		
		System.out.println(list.countNodes());
		
		System.out.println("Popping everything");
		while(!list.isEmpty()){
			System.out.println(list.removeCharFromFront());
		}
		
		list.addCharAtFront('o');
		list.addCharAtFront('l');
		list.addCharAtFront('l');
		list.addCharAtFront('e');
		list.addCharAtFront('H');
		
		System.out.println("Popping everything from the end");
		while(!list.isEmpty()){
			System.out.println(list.removeCharAtEnd());
		}
		System.out.println(list.countNodes());
		
		list.addCharAtEnd('o');
		list.addCharAtEnd('l');
		list.addCharAtEnd('l');
		list.addCharAtEnd('e');
		list.addCharAtEnd('H');
	
		list.reverse();
		System.out.println(list);
		
		list.reverse();
		System.out.println(list);
           
           DoublyLinkedList list2 = new DoublyLinkedList();
           list2.addCharAtEnd('O');
		list2.addCharAtEnd('K');
           list2.reverse();
		System.out.println(list2);
           System.out.println(list2.countNodes());
	}
    
}
