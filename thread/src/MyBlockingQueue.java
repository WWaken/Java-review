/**
 * @ClassName: MyBlockingQueue
 * @Description: 自己实现阻塞式队列：
 *                  1、满足线程安全的生产安全、消费功能
 *                  2、生产、消费达到上下限时，需要阻塞等待.
 * @Author: Ma Yuanyuan
 */
public class MyBlockingQueue<E> {

    private Object[] items;
    //弹出元素的索引
    private int takeIndex;
    //添加元素的索引
    private int putIndex;
    //有效容量
    private int size;

    public MyBlockingQueue(int capacity){
        items = new Object[capacity];
    }
    public synchronized void put(E e) throws InterruptedException {
        //达到上限，需要等待
        while (size == items.length){
            wait();
        }
        //存放元素的索引++，需要满足循环队列索引>数组长度的情况
        putIndex = (putIndex+1)%items.length;
        items[putIndex] = e;
        size++;
        notifyAll();
    }
    public synchronized E take() throws InterruptedException {
        //达到下限，需要等待
        while(size == 0) {
            wait();
        }
        takeIndex = (takeIndex+1)%items.length;
        size--;
        notifyAll();
        return (E) items[takeIndex];
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            final int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 100; j++) {
                            queue.put(k*100+j);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        while(true){
            int num = queue.take();
            System.out.println(num);
        }
    }
}
