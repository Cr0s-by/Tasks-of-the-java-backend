import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final int[] dx = {-2, -2, 2, 2};
    private final int[] dy = {-3, 3, -3, 3};

    public int minMovesToMeet(String startPosition, String endPosition) {
        // Переводим строки в координаты x, y
        int startX = convertCharToNum(startPosition.charAt(0));
        int startY = Character.getNumericValue(startPosition.charAt(1)) - 1;
        int endX = convertCharToNum(endPosition.charAt(0));
        int endY = Character.getNumericValue(endPosition.charAt(1)) - 1;

        boolean[][] visited = new boolean[8][8]; // Массив посещенных клеток
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // Количество элементов на текущем уровне
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];

                if (x == endX && y == endY) return moves; // Достигли цели

                // Проверяем все возможные ходы коня
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (isValid(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            moves++;
        }
        return -1; // Не нашли путь
    }

    // Функция для проверки корректности координат
    private boolean isValid(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    // Функция преобразования буквы в числовой эквивалент
    private int convertCharToNum(char c) {
        return c - 'a';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String startPos = "a1";
        String endPos = "d4";
        int result = solution.minMovesToMeet(startPos, endPos);
        System.out.println(result); // Вывод результата
    }
}