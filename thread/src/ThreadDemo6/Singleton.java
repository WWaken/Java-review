package ThreadDemo6;

/**
 * @ClassName: Sington
 * @Description: 饿汉模式
 * @Author: Ma Yuanyuan
 */
public class Singleton {
    private static Singleton SINGLETON = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return SINGLETON;
    }
}
