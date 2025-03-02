package Task2_4;

import java.util.Scanner;

public class Task4_3 {
    public static void main(String[] args) {
        System.out.println("Введите дату в формате 'дд.мм.гггг'");

        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();

        String[] dateNew = date.split("\\.");
        String formattedDate = dateNew[2] + "-" + dateNew[1] + "-" + dateNew[0];

        System.out.println(formattedDate);

    }
}
