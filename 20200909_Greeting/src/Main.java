
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        greeting(new String[]{"Petya", "Kolya", "Olya", "Katya"});
    }

    static void greeting(String[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello! What is your name? ");
        if (!scanner.hasNextInt()) { //проверку на опечатки можно расширить
            System.out.println(nameCheck(scanner.nextLine(), array));
        } else {
            System.out.println("Sorry, I didn't catch! Please, say once again.. \n");
        }
        greeting(array);
    }

    public static String nameCheck(String input, String[] array) {
        for (String s : array) {
            if (Objects.equals(s.toLowerCase(), input.toLowerCase())) {
                return "Hello, " + input.toUpperCase().charAt(0) + input.substring(1) + "! \n";
            }
        }
        return "Sorry, we are not familiar. \n";
    }
}
