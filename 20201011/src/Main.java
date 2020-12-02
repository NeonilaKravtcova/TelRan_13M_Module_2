import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shiftLeft(new int[]{6, 2, 5, 3})));//→ [2, 5, 3, 6]
        System.out.println(Arrays.toString(shiftLeft(new int[]{1, 2})));//[2, 1]
        System.out.println(Arrays.toString(shiftLeft(new int[]{1})));//[1]
        System.out.println();

        System.out.println(palindromeWordCheck("НАГАН"));//-> true
        System.out.println(palindromeWordCheck("ШАЛАШ"));//-> true
        System.out.println(palindromeWordCheck("ЦВЕТОК"));//-> false
        System.out.println(palindromeWordCheck("АрозаУПАЛАнаЛАПУАзора"));//-> true
        System.out.println();

        System.out.println(palindromeWordCheck2(new StringBuilder("НАГАН")));//-> true
        System.out.println(palindromeWordCheck2(new StringBuilder("ШАЛАШ")));//-> true
        System.out.println(palindromeWordCheck2(new StringBuilder("ЦВЕТОК")));//-> false
        System.out.println(palindromeWordCheck2(new StringBuilder("АрозаУПАЛАнаЛАПУАзора")));//-> true
        System.out.println();

        System.out.println(palindromeStringCheck("А РОЗА УПАЛА НА ЛАПУ АЗОРА"));//-> true
        System.out.println(palindromeStringCheck("Я арка края"));//-> true
        System.out.println(palindromeStringCheck("Аргентина манит негра"));//-> true
        System.out.println(palindromeStringCheck("ДОБРЫЙ ДЕНЬ"));//-> false
        System.out.println();

        System.out.println(Arrays.toString(fillArray01(10)));//-> {5,7,9,11,13}
        System.out.println();

        System.out.println(Arrays.toString(fillArray(5, 2, 5)));
        System.out.println();

        //System.out.println(findSumMinMaxOfArray(10));
        System.out.println(findSumMinMaxOfArray(new int[]{1, 3, 5, 6, 8, 12, 25, 3, 48}));//-> 49
        System.out.println();

        System.out.println(commonEnd(new int[]{1, 2, 3}, new int[]{7, 3}));//-> true
        System.out.println(commonEnd(new int[]{1, 2, 3}, new int[]{7, 3, 2}));// → false
        System.out.println(commonEnd(new int[]{1, 2, 3}, new int[]{1, 3}));// → true
        System.out.println();

        System.out.println(Arrays.toString(zeroMax(new int[]{0, 5, 0, 3})));// →[5, 5, 3, 3]
        System.out.println(Arrays.toString(zeroMax(new int[]{0, 4, 0, 3})));// →[3, 4, 3, 3]
        System.out.println(Arrays.toString(zeroMax(new int[]{0, 1, 0})));// →[1, 1, 0]
        System.out.println(Arrays.toString(zeroMax(new int[]{0, 4, 0, 3, 7, 0, 5})));// →[7, 4, 7, 3, 7, 5, 5]
        System.out.println();

        System.out.println(nonStart("Hello", "There"));// →"ellohere"
        System.out.println(nonStart("java", "code"));// →"avaode"
        System.out.println(nonStart("shotl", "java"));// →”hotlava"
        System.out.println();

        System.out.println(middleTwo("string"));// →"ri"
        System.out.println(middleTwo("code"));// →”od"
        System.out.println(middleTwo("Practice"));// → “ct"

    }

    public static int[] shiftLeft(int[] input) {
        if (input.length <= 1) {
            return input;
        } else {
            int temp = input[0];
            System.arraycopy(input, 1, input, 0, input.length - 1);
            input[input.length - 1] = temp;
        }
        return input;
    }

    public static boolean palindromeWordCheck(String input) {
        if (input.length() % 2 != 0) {
            int j = 1;
            for (int i = 0; i < (input.length() - 1) / 2; i++) {
                if (input.toLowerCase().charAt(i) == input.toLowerCase().charAt(input.length() - j)) {
                    j++;
                } else return false;
            }
            return true;
        }
        return false;
    }

    public static boolean palindromeWordCheck2(StringBuilder input) {
        int n = input.length();
        if (n % 2 == 0) {
            return input.substring(0, n / 2).equalsIgnoreCase(input.reverse().substring(0, n / 2));
        } else {
            return input.substring(0, (n - 1) / 2).equalsIgnoreCase(input.reverse().substring(0, (n - 1) / 2));
        }
    }

    public static boolean palindromeStringCheck(String input) {
        return palindromeWordCheck(input.replaceAll(" ", ""));
    }

    public static int[] fillArray01(int n) {
        int[] array = new int[n];
        array[0] = 0;
        for (int i = 1; i < n; i++) {
            array[i] = i % 2;
        }
        return array;
    }

    public static int[] fillArray(int number, int delta, int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = number;
            number += delta;
        }
        return array;
    }

/*    public static int[] createArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }*/

    public static int findSumMinMaxOfArray(int[] array/*int n*/) {
        //int[] array = createArray(n);
        System.out.println(Arrays.toString(array));
        int min = array[0];
        int max = array[0];
        //for (int i = 0; i < n - 1; i++) {
        for (int i = 0; i < array.length - 1; i++) {
            if (min > array[i + 1]) {
                min = array[i + 1];
            }
            if (max < array[i + 1]) {
                max = array[i + 1];
            }
        }
        System.out.println(min);
        System.out.println(max);
        return min + max;
    }

    public static boolean commonEnd(int[] array1, int[] array2){
        return array1[0] == array2[0] || array1[array1.length - 1] == array2[array2.length - 1];
    }

    public static int[] zeroMax(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == 0){
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] % 2 == 1 && a[j] > a[i]) {
                        a[i] = a[j];
                    }
                }
            }
        }
        return a;
    }

    public static String nonStart(String str1, String str2){
        return str1.substring(1) + str2.substring(1);
    }

    public static String middleTwo(String str) {
        return str.substring(str.length() / 2 - 1, str.length() / 2 + 1);
    }

}