/**
 * @ClassName: LinkedList
 * @Description: 链表
 * @Author: Ma Yuanyuan
 */

class LinkedNode{
    public int data;
    public LinkedNode next = null;

    public LinkedNode(int data) {
        this.data = data;
    }
}
public class LinkedList {
    private LinkedNode head = null;

    public void addFirst(int elem){
        LinkedNode node = new LinkedNode(elem);
        if(this.head == null){
            this.head = node;
            return;
        }
        node.next = head;
        this.head = node;
        return;
    }

    public int size(){
        int size = 0;
        for (LinkedNode cur = null; cur != null;cur= cur.next) {
            size++;
        }
        return size;
    }

    public void addLast(int elem){
        LinkedNode node = new LinkedNode(elem);
        if(head == null){
            this.head = node;
            return;
        }
        LinkedNode cur = this.head;
        while(cur != null){
            cur = cur.next;
        }
        cur.next = node;
    }

    public void addIndex(int pos ,int elem) {
        LinkedNode node = new LinkedNode(elem);
        int count = size();
        if (pos < 0 || pos > count) {
            return;
        }
        if (pos == 0) {
            addFirst(elem);
            return;
        } else if (pos == count) {
            addLast(elem);
        } else {
            LinkedNode prev = getPrevIndex(pos-1);
            node.next = prev.next;
            prev.next = node;
        }
    }
    private LinkedNode getPrevIndex(int pos){
        LinkedNode cur = this.head;
        for (int i = 0; i < pos ; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void delete(int toRemove){
        if(head == null){
            return;
        }
        if(head.data == toRemove) {
            this.head = this.head.next;
        }
        LinkedNode prev = searchPrev(toRemove) ;
        prev.next =prev.next.next;
    }

    private LinkedNode searchPrev(int toRemove){
        if(head == null){
            return null;
        }
        LinkedNode prev = this.head;
        while(prev.next != null){
            if(prev.next.data == toRemove){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
}
