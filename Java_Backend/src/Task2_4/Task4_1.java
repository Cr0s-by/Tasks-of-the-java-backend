package Task2_4;

import java.util.Scanner;

public class Task4_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите строку");
        String mainString = scan.nextLine();

        System.out.println("Введите подстроку");
        String substring = scan.nextLine();

        String[] parts = mainString.split(substring);
        int count = parts.length - 1;

        System.out.println("Подстрока '" + substring + "' встречается " + count + " раз");

    }
}