package Tasks_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class mainUser {
    private String name;
    private Integer age;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return name + ", возраст " + age + " лет";

    }

    public mainUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


}

public class Task3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<mainUser> users = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            String name = scanner.nextLine();


            System.out.println("Введите возраст пользователя " + (i + 1));
            int age = scanner.nextInt();
            scanner.nextLine();

            users.add(new mainUser(name, age));

        }
        Collections.sort(users, (u1, u2) -> Integer.compare(u1.getAge(), u2.getAge()));


        for (mainUser user : users) {
            System.out.println(user.toString());
        }

    }
}

