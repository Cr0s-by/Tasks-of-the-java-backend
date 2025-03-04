package Tasks_2;

import java.util.Scanner;

public class Task2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 3 числа");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        String result = "";
        if (a % 5 == 0) result += "a=" + a;
        if (b % 5 == 0) result += result.isEmpty() ? "b=" + b : ", b=" + b;
        if (c % 5 == 0) result += result.isEmpty() ? "c=" + c : ", c=" + c;

        System.out.println(result.isEmpty() ? "нет значений, кратных 5" : result);

        System.out.println("Результат целочисленного деления a на b: "+ a / b);


        double d = (double) a / b;
        System.out.println("Результат деления a на b: " + d);

        System.out.println("Результат деления a на b с округлением в большую сторону: " + (int) Math.ceil(d));

        System.out.println("Результат деления a на b с округлением в меньшую сторону: " + (int) Math.floor(d));

        System.out.println("Результат деления a на b с математическим округлением: " + (int) Math.round(d));

        System.out.println("Остаток от деления b на c: " + b % c);

        System.out.println("Наименьшее значение из a и b " + Math.min(a, b));

        System.out.println("Наибольшее значение из b и c: " + Math.max(b, c));


    }
}

