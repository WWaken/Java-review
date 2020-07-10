/**
 * @ClassName: MyThreadPool
 * @Description: 实现一个简单的线程池
 * @Author: Ma Yuanyuan
 */
public class MyThreadPool {

    private int size;
    private MyBlockingQueue<Runnable> queue;

    public MyThreadPool(int size,int capacity){
        queue = new MyBlockingQueue<>(capacity);
        //创建核心线程数
        for (int i = 0; i < size; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true) {
                            //从仓库取包裹可能成功取出，方法返回，马上执行
                            //也可能取不出包裹（阻塞在sychronized代码行，wait方法堵塞）
                            Runnable task = queue.take();
                            //当前线程运行run的实例方法
                            task.run();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void execute(Runnable task){
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(5,1000);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println('A');
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println('B');
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println('C');
            }
        });
    }
}
