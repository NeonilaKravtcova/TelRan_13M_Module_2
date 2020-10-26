package de.telran;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Exercise 1
        List<Person> personsList = new ArrayList<>();
        Collections.addAll(personsList, new Person("Vasya", new Address("Bahnhofstr.", 5)),
                new Person("Kolya", new Address("Hauptstr.", 12)),
                new Person("Petya", new Address("Mozartallee", 35)),
                new Person("Masha", new Address("Rathhausplatz", 1)),
                new Person("Sasha", new Address("St. Anna Gasse", 18)));

        System.out.println(Person.getAddresses(personsList));


        //Exercise 2
        List<String> names1 = Arrays.asList("Ivan", "Maria", "Stephan", "John", "John", "Amalia");
        System.out.println(noNamesLength4(names1));//Моя версия решения задачи без remove, поэтому метод работает
        //с неизменяемым списком

        //List<String> names2 = Arrays.asList("Ivan", "Maria", "Stephan", "John", "John", "Amalia");
        List<String> names2 = new ArrayList<>();
        Collections.addAll(names2, "Ivan", "Maria", "Stephan", "John", "John", "Amalia");
        System.out.println(noNamesLength4new(names2));//Метод работает только с изменяемым списком,
        // поэтому заполняем его через Collections

        //Exercise 3
        List<Integer> numbers1 = new ArrayList<>();
        List<Integer> numbers2 = new ArrayList<>();
        Collections.addAll(numbers1, 1, 2, 3, 4);
        Collections.addAll(numbers2, 5, 2, 3, 8);
        System.out.println(yesOrNo(numbers1, numbers2));
        List<Integer> numbers3 = Collections.emptyList();
        List<Integer> numbers4 = Collections.emptyList();
        System.out.println(yesOrNo(numbers3, numbers4));

        //Exercise 4
        List<String> letters1 = Arrays.asList("aa", "bb", "cc", "dd");
        List<String> letters2 = Arrays.asList("cc", "dd", "aa", "bb");
        List<String> letters3 = Arrays.asList("dd", "ee", "ff");
        List<String> letters4 = Arrays.asList("dd", "ff", "ee");
        System.out.println(isLooped(letters1, letters2));
        System.out.println(isLooped(letters3, letters4));

        //Exercise 5
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(reverseList(numbers5));
        System.out.println(reverseList2(numbers5));

        //Exercise 6
        System.out.println(mergeLists(numbers1, numbers2));

        List<String> names3 = new ArrayList<>();
        Collections.addAll(names3, "Ivan", "John");
        System.out.println(mergeLists(names2, names3));

        List<Person> personsList2 = new ArrayList<>();
        Collections.addAll(personsList2, new Person("Vasya", new Address("Bahnhofstr.", 5)),
                new Person("Kolya", new Address("Hauptstr.", 12)));
        System.out.println(mergeLists(personsList, personsList2));

        System.out.println(mergedList3(numbers1, numbers2));


        System.out.println(removeHigherThanNumber(numbers1, 3));
    }

    //Exercise 1 - метод был перенесён в класс Person
/*    public static List<Address> getAddresses(List<Person> persons) {
        List<Address> returnList = new ArrayList<>();
        for (Person person : persons) {
            returnList.add(person.address);
        }
        return returnList;
    }*/

    //Exercise 2 - моя версия
    public static List<String> noNamesLength4(List<String> input) {
        List<String> output = new ArrayList<>();
        if (input.isEmpty()) {
            return input;
        }
        if (input.size() == 1 && input.get(0).length() != 4) {
            return input;
        }
        int index = 0;
        for (String s : input) {
            if (s.length() != 4) {
                output.add(index, s);
                index++;
            }
        }
        return output;
    }

    //Exercise 2 - решение в классе
    public static List<String> noNamesLength4new(List<String> names) {
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() == 4) {
                iterator.remove();
            }
        }
        return names;
    }

    //Exercise 3
    public static List<String> yesOrNo(List<Integer> list1, List<Integer> list2) {
        if (list1.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> output = new ArrayList<>();
        if (list1.size() == 1) {
            if (list1.equals(list2)) {
                output.add(0, "Yes");
            } else {
                output.add(0, "No");
            }
            return output;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i))) {
                output.add(i, "Yes");
            } else {
                output.add(i, "No");
            }
        }
        return output;
    }

    //Exercise 4
    public static boolean isLooped(List<String> list1, List<String> list2) {
        if (list1.size() <= 1) {
            return true;
        }
        if (list1.equals(list2)) {
            return true;
        }
        for (int i = 0; i < list1.size(); i++) {
            Collections.rotate(list1, 1);
            if (list1.equals(list2)) {
                return true;
            }
        }
        return false;
    }

    //Exercise 5 - моя версия
    public static List<Integer> reverseList(List<Integer> input) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            output.add(i, input.get(input.size() - 1 - i));
        }
        return output;
    }

    //Exercise 5 - решение в классе
    public static List<Integer> reverseList2(List<Integer> num){
        List<Integer> reverseNumber = new ArrayList<>(num);
        Collections.reverse(reverseNumber);
        return reverseNumber;
    }

    //Exercise 6 - моя версия
    public static <E> List<E> mergeLists(List<E> list1, List<E> list2){
        List<E> output = list1;
        for (int i = 0; i < list2.size(); i++) {
            output.add(list2.get(i));
        }
        return output;
    }

    //Exercise 6 - решение в классе
    public static List<String> mergedList2(List<String> list1, List<String> list2) {
        List<String> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        return mergedList;
    }

    //Exercise 6 - обобщение предыдущего решения
    public static <E> List<E> mergedList3(List<E> list1, List<E> list2) {
        List<E> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        return mergedList;
    }

    //Exercise 7
    public static List<Integer> removeHigherThanNumber(List<Integer> listNumbers, int number){
        List<Integer> editList = new ArrayList<>(listNumbers);  //listNumber
        Iterator iterator = editList.iterator();
        while (iterator.hasNext()){
            int current = (int)iterator.next();
            if(current>number){
                iterator.remove();
            }
        }
        return editList;
    }


}

