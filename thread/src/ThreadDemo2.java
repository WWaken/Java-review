/**
 * @ClassName: ThreadDemo2
 * @Description: Thread的两种写法
 * @Author: Ma Yuanyuan
 */

public class ThreadDemo2 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //线程的启动 Thread-0
        myThread.start();
        //不启动线程，只在当前main方法中，调用了run()方法
        myThread.run();
        new Thread(new MyRunnable()).start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
