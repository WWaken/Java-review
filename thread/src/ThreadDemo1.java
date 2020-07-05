/**
 * @ClassName: ThreadDemo
 * @Description: 串行和并行运行时间的比较
 * @Author: Ma Yuanyuan
 */
public class ThreadDemo1 {
    private static final int NUM = 2;

    private  static void increment(){
        int count = 100000;
        for(int i = 0; i < count; i++){
            count++;
        }
    }
    private static void serial(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            increment();
        }
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("串行时间为" + result);
    }

    private static void parella(){
        long start = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        }).start();
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("并行时间为" + result);
    }
    public static void main(String[] args) {
        serial();
        parella();
    }
}
