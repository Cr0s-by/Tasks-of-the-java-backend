package Tasks_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Task3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            String name = scanner.nextLine();


            System.out.println("Введите возраст пользователя " + (i + 1));
            int age = scanner.nextInt();
            scanner.nextLine();

            users.add(new User(name, age));

        }
        Collections.sort(users, (u1, u2) -> Integer.compare(u1.getAge(), u2.getAge()));


        for (User user : users) {
            System.out.println(user.toString());
        }

    }
}

