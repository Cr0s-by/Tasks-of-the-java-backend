package Task2_4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task4_4 {
    public static void main(String[] args) {
        System.out.println("Введите дату в формате 'дд.мм.гггг'");

        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();


        try {
            SimpleDateFormat input = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");

            Date parsedDate = input.parse(date);
            String formattedDate = output.format(parsedDate);

            System.out.println(formattedDate);

        } catch (ParseException e) {
            System.out.println("Нераспаршена");
        }


    }
}
