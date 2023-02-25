package HW5;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Great_map {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        arrayCreat(arr);
        // arrayFilling(arr);
    //     while (arr.length >= 0) {
    //         if()
    //    }
        
        // вывод построчно
        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
     
    }

    public static void arrayCreat(int[][] arr) {
         // создание массива
         IntStream.range(0, 10).forEach(i -> {
            arr[i][i] = 0;
            int a = (int) ( Math.random() * 3 );
            arr[i][1 + a] = -1;
        });
    }
}
