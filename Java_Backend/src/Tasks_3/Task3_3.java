package Tasks_3;

import java.util.*;


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

public class Task3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<User>> ageMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            String name = scanner.nextLine();


            System.out.println("Введите возраст пользователя " + (i + 1));
            int age = scanner.nextInt();
            scanner.nextLine();

            User user = new User(name, age);

            List<User> usersList = ageMap.getOrDefault(age, new ArrayList<>());
            usersList.add(user);
            ageMap.put(age, usersList);
        }

        System.out.println("Введите требуемый возраст:");
        int searchAge = scanner.nextInt();

        List<User> users = ageMap.get(searchAge);
        if (users != null && !users.isEmpty()) {
            Collections.sort(users, Comparator.comparing(User::getName));

            for (User user : users) {
                System.out.println(user.toString());
            }
        } else {
            System.out.printf("Пользователь с возрастом '%d' не найден%n", searchAge);
        }


    }
}

