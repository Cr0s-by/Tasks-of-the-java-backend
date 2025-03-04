package Tasks_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task2_5 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Введите дату в формате dd.MM.yyyy:");
        Date date_1 = format.parse(scanner.nextLine());

////Дата после увеличения на 45 дней: 24.02.2024
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date_1);
        calendar.add(Calendar.DAY_OF_YEAR, 45);
        System.out.println("Дата после увеличения на 45 дней: " + format.format(calendar.getTime()));

//Дата после сдвига на начало года: 01.01.2024
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        System.out.println("Дата после сдвига на начало года: " + format.format(calendar.getTime()));


////Дата после увеличения на 10 рабочих дней: 24.01.2024
        calendar.setTime(date_1);
        int daysToAdd = 10;
        while (daysToAdd > 0) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                daysToAdd--;
            }
        }
        System.out.println("Дата после увеличения на 10 рабочих дней: " + format.format(calendar.getTime()));


//Введите вторую дату в формате dd.MM.yyyy
        System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
        Date date_2 = format.parse(scanner.nextLine());


//Количество рабочих дней между введенными датами: 7//
        Calendar start = Calendar.getInstance();
        start.setTime(date_1);
        Calendar end = Calendar.getInstance();
        end.setTime(date_2);

        if (!start.before(end)) {
            Calendar temp = start;
            start = end;
            end = temp;
        }

        int workDays = 0;
        while (start.before(end)) {
            int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);

            if (dayOfWeek != Calendar.SUNDAY &&
                    dayOfWeek != Calendar.SATURDAY) {
                workDays++;
            }
            start.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println("Количество рабочих дней между введенными датами: " + workDays);


    }
}
