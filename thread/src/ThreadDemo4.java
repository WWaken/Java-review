/**
 * @ClassName: ThreadDemo4
 * @Description: 线程不安全
 * @Author: Ma Yuanyuan
 */
public class ThreadDemo4 {
    private static final int NUM = 20;
    private static final int count = 10000;
    private static int num;
    private Thread thread;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < count; j++) {
                        num++;
                    }
                }
            });
            t.start();
        }
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(num);
    }
}
