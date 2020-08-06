import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MapTest
 * @Description: Map
 * @Author: Ma Yuanyuan
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"第二名");
        map.put(3,"第三名");
        map.put(3,"第三");
        System.out.println(map.size());
        System.out.println(map.get(3));
        System.out.println(map.get(5));
        System.out.println(map.getOrDefault(9,"倒数第三名"));
    }
}
