import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> mapAB = new HashMap<>();
        mapAB.put("a","Hi");
        System.out.println(createNewKey(mapAB));//->{“a”: “Hi”}
        mapAB.put("b","There");
        System.out.println(createNewKey(mapAB));//->{“a”: “Hi”, “ab”: “HiThere”, “b”: “There”}
    }

    public static Map<String, String> createNewKey(Map<String, String> map){
        List<String> keys = new ArrayList<>(map.keySet());
        List<String> values = new ArrayList<>(map.values());
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < map.size(); i++) {
            key.append(keys.get(i));
            value.append(values.get(i));
        }
        map.put(key.toString(), value.toString());
        return map;
    }
}
