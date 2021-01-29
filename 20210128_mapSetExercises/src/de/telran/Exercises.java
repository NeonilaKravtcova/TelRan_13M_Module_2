package de.telran;

import java.util.*;

public class Exercises {

    public <E> Set<E> listToSet(List<E> list) {
        return new HashSet<>(list);
    }


    public Map<String, List<Auto>> groupByMake(List<Auto> autos) {
        Map<String, List<Auto>> map = new HashMap();
        List<Auto> list = new ArrayList<>();

        Iterator<Auto> autosIterator = autos.iterator();
        Auto current = autosIterator.next();

        while (autosIterator.hasNext()) {
        //while(!autos.isEmpty()) {
            for (Auto auto : autos) {
                if (auto.make.equals(current.make)) {
                    System.out.println(auto.make);
                    list.add(auto);
                    autosIterator = null;
                    //autos.remove(auto);
                    //autosIterator.remove();
                }
            }
            map.put(current.make, list);
        }
        //}

        return map;
    }



}
