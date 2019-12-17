package study.singleLinkedList;

//导入一般结点的类
import study.singleLinkedList.Node;

/* 一条单链表的类
*
*  */

public class SingleLinkedList {
    public Node head; //头结点
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
    public Node tail; //尾结点
    public int size; //链表长度(链表中的元素个数)

    //无参构造方法
    public SingleLinkedList(){
        head = null;
        tail = null;
    }

    //链表中是否含有元素
    public boolean isEmpty(){
        return ( size==0? true : false );
    }

    //清空链表
    public void clear(){ //把 头尾都置为null(掐头去尾)，链表长度置为0
        head = null;
        tail = null;
        size = 0;
    }


    // get (index)：获取链表中第 index 个节点的值。如果索引无效，则返回 -1
    public int get( int index ){
        if( index<0 || index>(size-1) ){ //如果索引无效，则返回 -1
           return -1;
        }

        //让遍历的结点从head开始
        Node oneNode = head;
        //递增的步长：索引i++，并且让移动至下一个新结点 oneNode=oneNode.next
        for( int i=0;  i<size;  i++, oneNode=oneNode.next ){
            if( i==index ){
                return oneNode.val;
            }
        }

        return 0; //退出循环表名 查找失败
    }


    /* addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。
    * 插入后，新节点将成为链表的第一个节点。
    *  */
    public void addAtHead( int val ){
        /* 首先 生成一个新结点 newNode：数据域为新值val，其下一个结点next为  旧的head
        * 然后，(因为是 头插法，在原本的头结点前插入新结点嗷！)
        * 让此新结点成为 新的头结点 this.head
        *  */
        Node newNode = new Node( val, head );
        //让此新结点成为 新的头结点 this.head
        this.head = newNode;

        /* 如果原本是空链表this.tail==null，即初始没有任何元素
        * 那么新加入的 这一个结点newNode
        * 既是 头结点，也是尾结点，即：this.tail = this.head(这是新的结点嗷！)
        *  */
        if( this.tail==null ){
            this.tail = this.head;
        }
        //插入成功后，链表长度【手动地】加1！！
        this.size++;
    }

}
