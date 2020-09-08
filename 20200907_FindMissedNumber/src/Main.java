public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 5, 6};
        System.out.println(findMissedNumber(array));
        System.out.println(findMissedNumber2(array));
    }

    public static int findMissedNumber(int[] input){
        for (int i = 0; i < input.length; i++) {
            if (input[i] != i + 1){
                return i + 1;
            }
        }
        return 0;
    }

    public static int findMissedNumber2(int[] input){
        int sum = 0, sumI = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            sumI = sum + i;
        }
        return sumI - sum;
    }
}
