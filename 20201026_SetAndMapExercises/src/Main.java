import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Exercise 1
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 2, 3, 3, 4, 5, 6, 4);
        System.out.println(removeDuplicates(numbers));//-> {1,2,3,4,5,6}
        System.out.println();

        //Exercise 2
        List<Integer> numbers1 = new ArrayList<>();
        Collections.addAll(numbers1, 1, 2, 3, 3, 4, 5, 6, 4);
        System.out.println(getDuplicates(numbers1));//-> {3, 4}
        System.out.println();

        List<Integer> numbers2 = new ArrayList<>();
        Collections.addAll(numbers2, 1, 2, 3, 3, 3, 4, 5, 6, 7, 4, 7, 7);
        System.out.println(getDuplicates(numbers2));//-> {3, 3, 4, 7, 7}

    }

    //Exercise 1
    public static List<Integer> removeDuplicates(List<Integer> input) {
        return new ArrayList<>(new HashSet<>(input));
    }

    //Exercise 2
    public static List<Integer> getDuplicates(List<Integer> input) {
        List<Integer> output = removeDuplicates(input);
        for (Integer integer : output) {
            input.remove(integer);
        }
        return input;
    }


}
