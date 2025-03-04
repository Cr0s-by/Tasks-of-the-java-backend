package Tasks_2.Task2_4;

import java.util.Scanner;

public class Task4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку");
        String text = scanner.nextLine();
        String repltext = text.replace("кака", "вырезано цензурой")
                .replace("бяка", "вырезано цензурой");
        System.out.println(repltext);
    }
}

