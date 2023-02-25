package HW5;

// библиотеки
import java.util.Scanner;

//........

public class Great_map {
    public static void main(String[] args) {
        // body
        int[][] arr = MapCreate();
        int[] queue_row = new int[arr.length * arr.length];
        int[] queue_col = new int[arr.length * arr.length];
        //начальные данные
        int [] pointStart = StartPosition(arr);
        int [] pointsFinish = PointsFinish(arr); 
        //
        ArrayCreat(arr, pointStart, pointsFinish);
        // Маркировка маршрута
        PathMarking(arr, pointStart[0], pointStart[1], queue_row, queue_col, 0);
        //выбор пути

        // end
        System.out.println(RawData(arr));
    }

    static String RawData(int[][] map) {
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
        System.out.println("Строим карту ");
        System.out.print("Введите количество строк: ");
        int row = input.nextInt();
        System.out.print("Введите количество столбцов: ");
        int col = input.nextInt();
        int[][] array = new int[row][col];
        return array;
    } 
    
    private static int[] StartPosition(int arr[][]){
        // init
        Scanner input = new Scanner(System.in);
        int [] point = new int[2];
        String str_2 = String.format("Вводите значение в диапазоне от ", 1, " до " , arr.length - 2);
        // body
        System.out.println("Точка старта ");
        System.out.println(str_2);

        System.out.print("Введите номер строки: ");
        point[0] = input.nextInt();
        System.out.print("Введите номер столбца: ");
        point[1] = input.nextInt();
        return point;
    }

    public static void ArrayCreat(int[][] arr,int[] start, int []finish) {
         // создание массива-карты
         //////////////////////
         // -1  -> стена
         // -5  -> финиш
         //  1  -> старт 
         //////////////////////
         // формируем стены 
         for (int i = 0; i < arr.length; i++) {
            arr[0][i] = -1;
            arr[arr.length-1][i] = -1;
         }
         for (int i = 0; i < arr.length; i++) {
            arr[i][0] = -1;
            arr[i][arr.length-1] = -1;
         }
        // обозначаем старт 
        arr[start[0]][start[1]] = 1;
        // наносим финишные точки
        for (int i = 0; i < finish.length; i+=2) {
            arr[finish[i]][finish[i+1]] = -5;
        }
        // обозначаем препядствия
        // сырой вариант
       // Wall(arr);
    }

    // private static void Wall(int[][] arr) {
    //     boolean flag = true;
    //     while(flag){
    //         int count = 0;
    //         int row_no = (int) ( Math.random() * arr.length );
    //         int col_no = (int) ( Math.random() * arr.length );
    //         if (arr[row_no][col_no] == 0) arr[row_no][col_no] = -1;
    //         count++;
    //         if (count>3) flag = false;
    //     }
    // }
    
    private static int[] PointsFinish(int arr[][]){
        // init
        Scanner input = new Scanner(System.in);
        System.out.print("Введите введите количество выходов: ");
        int countPoint = input.nextInt();

        int [] points = new int[countPoint*2];
        // body
            // Записываем в массив по 2 элемента => шаг увеличиваем на 2
            for (int i = 0; i < countPoint; i+=2) {
                String str = String.format("Ввод точки финиша № ", i);
                String str_2 = String.format("Вводите значение в диапазоне от ", 1, " до " , arr.length - 2);
                System.out.println(str);
                System.out.println(str_2);

                while(true){
                    System.out.print("Введите номер строки: ");
                    points[i] = input.nextInt();

                    if(points[i] > 1 && points[i] < arr.length - 1){
                        break;
                    }
                    else{
                        System.out.println("Вы вышли за пределы возможного диапазона ");
                        System.out.println(str_2);
                    }

                }

                while(true){
                    System.out.print("Введите номер столбца: ");
                    points[i+1] = input.nextInt();

                    if(points[i+1] > 1 && points[i+1] < arr.length - 1){ 
                        break;
                    }
                    else{
                        System.out.println("Вы вышли за пределы возможного диапазона ");
                        System.out.println(str_2);
                    }

                }
            }
        // end
        return points;
    }


    public static void PathMarking(int[][] arr, int x, int y, int [] row , int [] col, int index) {
        //[строка][столбец]
        //ограничение по массиву
                NeighborhoodLabeling(arr, x, y, row, col, index);       //System.out.println(rawData(arr));
    }
    //neighborhood labeling

    private static void NeighborhoodLabeling(int[][] arr, int x, int y, int[] row, int[] col, int index) {
        if (arr[x-1][y]!= -1 && arr[x-1][y] == 0){
            arr[x-1][y] = arr[x][y] + 1;
            row[index] = x-1;
            col[index] = y;
            index ++;
        }
        if (arr[x][y+1]!= -1 && arr[x][y+1] == 0){
            arr[x][y+1] = arr[x][y] + 1;
            row[index] = x;
            col[index] = y+1;
            index ++;
        }
        if (arr[x+1][y]!= -1 && arr[x+1][y] == 0){
            arr[x+1][y] = arr[x][y] + 1;
            row[index] = x+1;
            col[index] = y;
            index ++;
        }
        if (arr[x][y-1]!= -1 && arr[x][y-1] == 0){
            arr[x][y-1] = arr[x][y] + 1;
            row[index] = x;
            col[index] = y-1;
            index ++;
        }
    }
}
