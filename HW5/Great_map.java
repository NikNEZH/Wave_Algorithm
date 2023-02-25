package HW5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Great_map {
    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        //под очередь
        int [] pointStart = {1,1};
        //
        arrayCreat(arr, pointStart);
        // вывод построчно
        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
        //маркировка маршрута
        PathMarking(arr, pointStart[0], pointStart[1]);

        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
    }

    public static void arrayCreat(int[][] arr,int[] start) {
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
            arr[start[0]][start[1]] = 1;
        });
    }
    public static int [][] PathMarking(int[][] arr, int x, int y) {
        //[строка][столбец]
        //ограничение по массиву
                if (arr[x-1][y]!= -1 && arr[x-1][y] == 0){
                    arr[x-1][y] = arr[x][y] + 1;
                    arr = PathMarking(arr, x - 1, y);
                }
                if (arr[x][y+1]!= -1 && arr[x][y+1] == 0){
                    arr[x][y+1] = arr[x][y] + 1;
                    arr = PathMarking(arr, x , y + 1);
                }
                if (arr[x+1][y]!= -1 && arr[x+1][y] == 0){
                    arr[x+1][y] = arr[x][y] + 1;
                    arr = PathMarking(arr, x + 1 , y);
                }
                if (arr[x][y-1]!= -1 && arr[x][y-1] == 0){
                    arr[x][y-1] = arr[x][y] + 1;
                    arr = PathMarking(arr, x , y - 1);
                }
                /////////////////////////////////////////////////////////
                System.out.println("________________________________");
                Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
                System.out.println("________________________________");
                /////////////////////////////////////////////////////////
                return arr;
    }
}
