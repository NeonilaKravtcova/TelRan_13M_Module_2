package de.telran;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //StringBuffer - это класс, который можно изменить
        //он линкует ссылку на старые объекты к новым
        StringBuffer sb = new StringBuffer();//по умолчанию резервирует в памяти место под 16 символов
        StringBuffer sb1 = new StringBuffer(32);//а так - под 32 символа
        StringBuffer sb2 = new StringBuffer("Hello!");
        StringBuffer sb3 = new StringBuffer(String.valueOf(new char[]{'a', 'b'}));

        System.out.println(sb2.capacity());
        System.out.println(sb2.length());

        sb2.append(" my friend!");
        System.out.println(sb2.capacity());
        System.out.println(sb2.length());
        System.out.println(sb2);
        sb2.setCharAt(5, ',');
        System.out.println(sb2);
        sb2.insert(10,"dear ");
        System.out.println(sb2);

        sb2.delete(1, 3);
        System.out.println(sb2);

        System.out.println(sb2.charAt(6) + "\n");


        sb1 = sb2;
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb2.reverse());
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println();

        int[] nums = {1, 2, 3};
        System.out.println(sb1.append(5).append("!!!").append(Arrays.toString(nums)).append(';'));
        System.out.println(sb1);

        //sb.insert();
        sb1.setLength(sb1.length() - 5);
        System.out.println(sb1);

        System.out.println(sumNumbers("12345"));
        System.out.println(sumNumbers(new StringBuffer("67890")));
        System.out.println();

        printRepeatChar("aaabbcdddd");
        printRepeatChar("a");
        printRepeatChar("");

    }

    private static int sumNumbers(String input){
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += Integer.parseInt(input.substring(i, i + 1));//
        }
        return sum;
    }

    private static int sumNumbers(StringBuffer sb){//перегружаем метод
        char[] chars = new char[sb.length()];
        sb.getChars(0, chars.length, chars, 0);
        int sum = 0;
        for (char c : chars) {
            sum += Character.digit(c, 10);

        }
        return sum;
    }

    //printRepeatChar("aaabbcdddd") -> a3b2c1d4
    private static void printRepeatChar(String input){
        if (input.equals("")){
            System.out.println("String is empty");
        } else {
            int count = 1;
            char c = input.charAt(0);
            StringBuffer output = new StringBuffer();
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) == c) {
                    count++;
                } else {
                    output = output.append(c).append(count);
                    c = input.charAt(i);
                    count = 1;
                }
            }
            output = output.append(c).append(count);
            System.out.println(output);
        }
    }
}
