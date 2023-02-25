package HW5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Great_map {
    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        arrayCreat(arr);
        // вывод построчно
        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
     
    }

    public static void arrayCreat(int[][] arr) {
         // создание массива
         IntStream.range(0, 6).forEach(i -> {
            arr[i][i] = 0;
            arr[5][i] = -1;
            arr[0][i] = -1;
            arr[i][0] = -1;
            arr[i][5] = -1;
        // ставим искуственно барьеры
            arr[1][3] = -1;
            arr[2][3] = -1;
            arr[3][3] = -1;
        });
    }
}
