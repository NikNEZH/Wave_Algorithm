package HW5;

import java.util.Arrays;
import java.util.stream.IntStream;

import javax.swing.RowFilter;

import java.util.Scanner;
public class Great_map {
    public static void main(String[] args) {
        // init
        Scanner input = new Scanner(System.in);
        // body
        int[][] arr = MapCreate();
        //начальные данные
        System.out.println("Введите количество выходов");
        int count = input.nextInt();
        int [] pointStart = startPosition();
        int [] [] pointFinish = new int [count]{count}; 
        //
        arrayCreat(arr, pointStart);

        // Маркировка маршрута
        PathMarking(arr, pointStart[0], pointStart[1]);
        // end
        System.out.println(rawData(arr));
    }

    static String rawData(int[][] map) {
        // init
        StringBuilder sb = new StringBuilder();
        // body
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%3d",map[row][col]));
            }
            sb.append("\n");
        }
        // end
        return sb.toString();
    }
    
    private static int[][] MapCreate(){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int row = input.nextInt();
        System.out.print("Введите количество столбцов: ");
        int col = input.nextInt();
        int[][] array = new int[row][col];
        return array;
    } 
    
    private static int[] startPosition(){
        // init
        Scanner input = new Scanner(System.in);
        int [] point = new int[2];
        // body
        System.out.print("Введите номер строки: ");
        point[0] = input.nextInt();
        System.out.print("Введите номер столбца: ");
        point[0] = input.nextInt();
        return point;
    }

    public static void arrayCreat(int[][] arr,int[] start) {
         // создание массива
         for (int i = 0; i < arr.length; i++) {
            arr[0][i] = -1;
            arr[arr.length-1][i] = -1;
         }
         for (int i = 0; i < arr.length; i++) {
            arr[i][0] = -1;
            arr[i][arr.length-1] = -1;
         }

        arr[start[0]][start[1]] = 1;
    }
    public static void PathMarking(int[][] arr, int x, int y) {
        //[строка][столбец]
        //ограничение по массиву
                if (arr[x-1][y]!= -1 && arr[x-1][y] == 0){
                    arr[x-1][y] = arr[x][y] + 1;
                    // arr = PathMarking(arr, x - 1, y);
                }
                if (arr[x][y+1]!= -1 && arr[x][y+1] == 0){
                    arr[x][y+1] = arr[x][y] + 1;
                    // arr = PathMarking(arr, x , y + 1);
                }
                if (arr[x+1][y]!= -1 && arr[x+1][y] == 0){
                    arr[x+1][y] = arr[x][y] + 1;
                    // arr = PathMarking(arr, x + 1 , y);
                }
                if (arr[x][y-1]!= -1 && arr[x][y-1] == 0){
                    arr[x][y-1] = arr[x][y] + 1;
                    // arr = PathMarking(arr, x , y - 1);
                }

                //System.out.println(rawData(arr));
    }
}
