package de.telran;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Counter {

    public Map<Integer, Integer> repeatCounter(List<Integer> integers){

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer elt : integers){
            if (!map.containsKey(elt)){
                map.put(elt, 1);
            } else {
                map.put(elt, map.get(elt) + 1);
            }
        }

        return map;
    }

}
