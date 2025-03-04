package Tasks_2.Task2_4;

import java.util.Scanner;

public class Task4_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите строку");
        String mainString = scan.nextLine();

        System.out.println("Введите подстроку");
        String substring = scan.nextLine();

        int count = 0;
        int index = 0;

        while (true) {
            index = mainString.indexOf(substring, index);

            if (index == -1) {
                break;
            }

            count++;
            index += substring.length();
        }

        System.out.println("Подстрока '" + substring + "' встречается " + count + " раз");

    }
}