//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.PriorityBlockingQueue;
//
///**
// * @ClassName: MyTimer
// * @Description: 定时器
// *                1.在约定好的时间点上，执行某个任务
// *                2.间隔时间到了，不停执行任务
// * @Author: Ma Yuanyuan
// */
//public class MyTimer {
//    private BlockingQueue<Runnable> queue = new PriorityBlockingQueue();
//
//    public MyTimer(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while(true){
////                        MyTimer.MyTimerTask task = (MyTimerTask) queue.take();
////                        synchronized (queue){
////                        long current = System.currentTimeMillis();
////                        if(task.next < current){
////                            Thread.sleep(current -task.next);
////                        }
////                    }
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            }
////        }).start();
////    }
//
//    /**
//     * 定时任务
//     * @param task 需要执行的任务
//     * @param delay 从当前时间延迟了多少毫秒，执行任务
//     * @param period 间隔时间
//     */
////    public void schedule(Runnable task, long delay,long period) {
////        try {
////            queue.put(new MyTimerTask(task, System.currentTimeMillis()+delay,period));
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////    }
////
////    private  class MyTimerTask implements Runnable,Comparable<MyTimerTask>{
//
//        //定时任务
//        private  Runnable task;
//        //下次执行时间
//        private long next;
//        private long period;
//        public MyTimerTask(Runnable task, long next,long period){
//            this.task = task;
//            this.next = next;
//            this.period = period;
//        }
//        @Override
//        public void run() {
//
//        }
//
//        @Override
//        public int compareTo(MyTimerTask o) {
//            return Long.compare(next,o.next);
//        }
//    }
//    //原生的Timer
////    public static void main(String[] args) {
////       // Date date = new Date();
////        TimerTask task  = new TimerTask() {
////            @Override
////            public void run() {
////                System.out.println("找工作！！！！");
////            }
////        };
////        new Timer().schedule(task, 3000,100);
////    }
////    public static void main(String[] args) {
////        new MyTimer().schedule(new Runnable() {
////            @Override
////            public void run() {
////                System.out.println("找工作！！！");
////            }
////        },3000,1500);
//
////    public static void main(String[] args) {
////        //创建单个线程
////        ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);
////        pool.schedule(new Runnable() {
////            @Override
////            public void run() {
////                System.out.println("找工作！！！");
////            }
////        },1, TimeUnit.SECONDS);
////    }
//}
