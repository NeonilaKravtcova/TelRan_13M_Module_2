package de.telran;

import java.util.*;

public class Exercises {

    public <E> Set<E> listToSet(List<E> list) {
        return new HashSet<>(list);
    }

    public Map<String, List<Auto>> groupByMake(List<Auto> autos) {
        Map<String, List<Auto>> map = new HashMap();
        for (Auto auto : autos){
            List<Auto> list;
            if (!map.containsKey(auto.make)){
                list = new ArrayList<>();
            } else {
                list = map.get(auto.make);
            }
            list.add(auto);
            map.put(auto.make, list);
        }
        return map;
    }

    public List<List<String>> sortByAlphabet(List<String> input){

        List<List<String>> res = new ArrayList<>();

        List<String> list = new ArrayList<>(input);

        Collections.sort(list);

        int index = 0;

        String currentWord = list.get(0);
        List<String> subList = new ArrayList<>();
        subList.add(0, currentWord);
        res.add(index, subList);

        for (int i = 1; i < list.size(); i++) {
            currentWord = list.get(i);
            if ((res.get(index).get(0).substring(0, 1)).equals(currentWord.substring(0, 1))){
                res.get(index).add(currentWord);
            }
            else {
                index++;
                res.add(index, new ArrayList<>(Collections.singleton(currentWord)));
            }
        }

        return res;
    }


}
