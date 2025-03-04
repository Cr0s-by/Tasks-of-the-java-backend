package Tasks_3;

import java.util.Scanner;


class User {
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

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

public class Task3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя первого пользователя");
        String name1 = scanner.nextLine();
        System.out.println("Введите возраст первого пользователя");
        int age1 = scanner.nextInt();
        scanner.nextLine();

        User user1 = new User(name1, age1);


        System.out.println("Введите имя второго пользователя");
        String name2 = scanner.nextLine();
        System.out.println("Введите возраст второго пользователя");
        int age2 = scanner.nextInt();

        User user2 = new User(name2, age2);


        if (user1.getAge() <= user2.getAge()) {
            System.out.println(user1.toString());
        } else {
            System.out.println(user2.toString());
        }
    }
}
