package Tasks_2;

import java.util.Random;

public class Task2_3 {
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();


        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(16);
        }

        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");


        for (int i = 1; i <= 15; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i) {
                    count++;
                }
            }
            if (count > 1) {
                System.out.println("Число " + "'" + i + "'" + " встречается " + count + " раза");
            }
        }
    }
}