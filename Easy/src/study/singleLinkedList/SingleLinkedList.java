package study.singleLinkedList;

//导入一般结点的类
import study.singleLinkedList.Node;

/* 一条单链表的类
*
*  */

public class SingleLinkedList {
    public Node head; //头结点
    // 规定：这里的头结点 就是 链表中的第一个元素

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
    // 规定：这里的尾结点 就是 链表中的最后一个元素

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

    //在尾部添加
    public void addAtTail(int val){
        //如果在初始时的表为空
        if( head==null ){
            //即将成为尾结点 的新结点，值为新的val。但是它没有next，所以为null
            Node newNode = new Node( val, null );
            //头结点和尾结点都是 newNode
            tail = newNode;
            head = newNode;
        }else{
            //即将成为尾结点 的新结点，值为新的val。但是它没有next，所以为null
            Node newNode = new Node( val, null );
            tail.next = newNode; //更改next域：让原本的tail结点 不是尾结点——原tail的next是 newNode
            tail = newNode; //正式更改尾结点
        }

        this.size++;
    }

    /* addAtIndex (index,val)：
    * 在链表中的第 index 个节点之前添加值为 val 的节点。
    * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
    * 如果 index 大于链表长度，则不会插入节点。
    * 如果 index 小于 0，则在头部插入节点。
    *  */
    public void addAtIndex(int index, int val) {
        if( index==this.size ){ //如果 index 等于链表的长度，则该节点将附加到链表的末尾
            this.addAtTail( val );
        }else if( index>this.size ){
            System.out.println( "index 大于链表长度，则不会插入结点嗷！" );
        }else if( index<0 ){ // 如果 index 小于 0，则在头部插入节点。
            this.addAtHead( val );
        }else if( index>0 && index<=size-1 ){ //正常情况

            Node oneNode = head; //从head头结点开始遍历嗷！

            /* 下标i 如何与node结点建立起对应关系？
            * 答：i=0时，oneNode=head，从head开始；
            * 【递增时】 i=i+1(下标递增1)，
            * 相应的 oneNode就变成 oneNode的下一个结点(递增的结点也是递增1个)
            *
            * 当 i=某个下标时，for循环里就取到那个结点(不断.next)，就对那个结点操作，就是这样对应的。
            *  */
            for( int i=0; i<this.size; i++,oneNode=oneNode.next ){
                /* if( i==index ) 不要使用倒退的方法，这样取不到前一个结点！！要善于利用.next .next
                 * 正确：i==(index-1)，画图，先连后断
                 *  */
                if( i==(index-1) ){
                    /* 此时 第index-1个结点 是oneNode
                     * oneNode的下一个结点是 oneNode.next，它将要成为newNode的next域！！
                     *  */
                    Node newNode_next = oneNode.next;
                    //先连：让 newNode 指向 oneNode.next
                    Node newNode = new Node( val, newNode_next );
                    //oneNode的下一个结点指向 新结点
                    oneNode.next = newNode;
                    this.size++;
                }
            }
        }

    }


    /* deleteAtIndex (index)：
    * 如果索引 index 有效，则删除链表中的第 index 个节点。
    *
    *  */
    public void deleteAtIndex(int index){
        if( index<0 || index>size-1 ){ //下标最大可以取到 size-1
            throw new IndexOutOfBoundsException("索引越界");
        }else{

            Node oneNode = head; //从头结点开始遍历嗷！
            for( int i=0; i<size; i++, oneNode=oneNode.next ){
                if( i==0 ){ //如果删除第一个元素
                    //让head转移给下一位
                    this.head = this.head.next;
                    oneNode = null; //oneNode就是被删除的元素嗷！
                }


                //画图可知，索引要取到index-1
                if( i==index-1 ){
                    Node wantToDelete = oneNode.next; //将要删除的结点
                    oneNode.next = wantToDelete.next; //让oneNode下一个结点 跨过wantToDelete 指向下一个
                    wantToDelete = null; //删除wantToDelete
                    size--;
                }
            }
        }
    }
}
