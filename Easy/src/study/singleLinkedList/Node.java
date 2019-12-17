package study.singleLinkedList;

//单链表中，【某个结点】的类

public class Node {
    /* 为了方便，这两个变量都使用public 而不用private，
    * 这样就不用写set、get方法了
    * */

    //某个结点的数据值( Object类型，或基本数据类型 int等 )
    public int val;
    //此结点的 “下一个结点”的实例对象 的引用
    public Node next;

    //构造方法，在构造时就能给成员变量 val赋值
    public Node( int val ){
        this.val = val;
    }

    public Node( int val, Node next ){
        this.val = val;
        this.next = next;
    }

}
