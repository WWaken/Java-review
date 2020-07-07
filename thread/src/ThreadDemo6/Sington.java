package ThreadDemo6;

/**
 * @ClassName: Singtom
 * @Description:多线程安全懒汉模式  ——双重校验锁
 * @Author: Ma Yuanyuan
 */
public class Sington {
    private Sington(){

    }
    private static  volatile Sington SINGTON = null;

    public static Sington getInstance(){
        if(SINGTON == null){
            synchronized (Sington.class){
                //为了保证单例：返回的同一个对象
                if(SINGTON  == null){
                    SINGTON = new Sington();
                }
            }
        }
        return SINGTON;
    }
}
