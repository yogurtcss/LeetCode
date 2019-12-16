package study.singleLinkedList;

//导入一般结点的类
import study.singleLinkedList.Node;

/* 一条单链表的类
*
*  */

public class SingleLinkedList {
    private Node head; //头结点
    /* 在大多数情况下，我们将使用头结点 (第一个结点) 来表示整个列表。
    * 头结点是为了操作的统一与方便而设立的，放在第一个元素结点之前，
    * 其数据域一般无意义（当然有些情况下也可存放链表的长度、用做监视哨等等）。
    *
    * head 为结点，它不存放任何的数据，只是充当一个指向链表中真正存放数据的第一个结点
    *
    *
    * 所以，头结点不算入 线性表(单链表)的元素结点！！
    * 所以初始化头结点时， 单链表中没有元素 即 this.size=0
    *
    * 有了头结点后，对在第一个元素结点前插入结点和删除第一个结点，其操作与对其它结点的操作统一了。
    *
    * 头结点不是链表所必需的
    *
    *  */

    private Node current; //当前结点
    private int size; //此条单链表的长度

    //单链表的无参构造方法
    public SingleLinkedList(){
        //初始时：没有任何元素结点(单链表长度为0)，当前结点就是头结点
        current = new Node( null ); //当前结点和 头结点的数据域为空
        head = current; //当前结点就是头结点
        this.size = 0; //没有任何元素结点(单链表长度为0)
    }

    //判断当前单链表是否为空
    public boolean isEmpty(){
        return ( this.size==0 ? true : false );
    }



}
