package hashMap;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Jason Tan on 2022-09-06 22:03
 */
public class HashMapJason {

    public static void main(String[] args) {
        //       key     value
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"I am 1");
        map.put(2,"I am 2");
        map.put(3,"I am 3");
        map.put(4,"I am 4");
        map.put(5,"I am 5");

        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(10));

        System.out.println(map.get(1));
        System.out.println(map.get(10));

        map.put(1,"He is 1");
        System.out.println(map.get(1));
        System.out.println("====================================");

        //       key
        HashSet<String> set = new HashSet<>();
        set.add("abc");
        System.out.println(set.contains("abc"));
        set.remove("abc");
    }
}
