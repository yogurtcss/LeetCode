package study.singleLinkedList;

//单链表中，【某个结点】的类

public class Node {
    //某个结点的数据值( Object类型，或基本数据类型 int等 )
    Object data;
    //此结点的 “下一个结点”的实例对象 的引用
    Node next;

    //一般结点的构造方法
    public Node(Object data, Node next ){
        this.data = data;
        this.next = next;
    }

    //构造方法：在构造时就能给数据域data赋值
    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
