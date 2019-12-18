package study.singleLinkedList;

import study.singleLinkedList.SingleLinkedList;

public class Main {

    public static void test(){
        SingleLinkedList list = new SingleLinkedList();
        list.addAtHead( 233 );
        //list.addAtTail( 2 );

        //list.clear();

        //list.addAtIndex( 1, 456 );
        list.deleteAtIndex( 0 );
        System.out.println( list.get(0) );
    }


    public static void main(String[] args) {
        test();
    }
}
