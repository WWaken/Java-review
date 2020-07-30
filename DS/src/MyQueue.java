/**
 * @ClassName: MyStack
 * @Description: MyStack
 * @Author: Ma Yuanyuan
 */

public class MyQueue{
    private int[] data = new int[100];
    // [head, tail)
    private int head = 0; // 队首元素的下标
    private int tail = 0; // 队尾元素的下标
    private int size = 0;

    // 1. 入队列, 如果插入成功, 返回 true, 否则返回 false
    //    如果队列满了, 再插入就会失败
    public boolean offer(int x) {
        if (size == data.length) {
            return false;
        }
        // 新元素放到 tail 的位置上
        data[tail] = x;
        tail++;
        if (tail == data.length) {
            tail = 0;
        }
        size++;
        return true;
    }

    // 2. 出队列
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer ret = data[head];
        head++;
        if (head == data.length) {
            head = 0;
        }
        size--;
        return ret;
    }

    // 3. 取队首元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return data[head];
    }

    // 4. 判定为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 5. 取长度
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        while (!myQueue.isEmpty()) {
            Integer cur = myQueue.peek();
            System.out.println(cur);

        }
    }
}

