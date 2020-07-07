/**
 * @ClassName: ThreadDemo
 * @Description: java类作用描述
 * @Author: Ma Yuanyuan
 */
public class ThreadDemo7{

    //库存面包数量：上限100,下限0
    private static volatile int Sum;

    public static void main(String[] args) {
        //启动生产者生产面包
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(),"面包师傅" + i).start();
        }
        //启动消费者消费面包
        for (int i = 0; i < 20; i++) {
            new Thread(new Consumer(),"消费者" + i).start();
        }
    }

    //默认生产者：面包师傅生产面包：一次生产三个面包
    private static class Producer implements Runnable{
        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (ThreadDemo7.class){
                        if(Sum + 3 >100){
                            //释放对象锁，让其他线程进入同步代码块，当前线程进入阻塞状态
                            ThreadDemo7.class.wait();
                        }
                        Sum += 3;
                        Thread.sleep(100);
                        ThreadDemo7.class.notify();
                        System.out.println(Thread.currentThread().getName() + "生产了，库存为 "+Sum);
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //默认消费者：一次消费一个面包
    private static class Consumer implements Runnable{
        @Override
        public void run() {
            try {
                while(true){
                    synchronized (ThreadDemo7.class){
                        while (Sum == 0){
                            //库存为0，不能继续消费
                            ThreadDemo7.class.wait();
                        }
                        Sum--;
                        Thread.sleep(100);
                        ThreadDemo7.class.notify();
                        System.out.println(Thread.currentThread().getName() +"消费了，库存为"+ Sum);
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
