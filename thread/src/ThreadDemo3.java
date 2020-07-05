/**
 * @ClassName: ThreadDemo3
 * @Description: 设置DaemoThread（守护线程）
 * @Author: Ma Yuanyuan
 */

//至少有一个线程是非守护线程没有被销毁(main线程退出了)
//非守护线程成为工作线程，守护线程被称为后台线程
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(888);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }
}
