package Wave_algorithm;

// библиотеки
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        int rows = request_validation.inputNum("Введите количество строк поля. ", iScanner);
        int columns = request_validation.inputNum("Введите количество столбцов поля. ", iScanner);
        int walls = request_validation.inputNum("Введите количество стен. ", iScanner);
        while (!request_validation.numberWalls(rows, columns, walls)) {
            System.out.println("Количество стен превышает количество ячеек.");
            System.out.printf("Количество стен должно быть в диапазоне от 0 до %d.\n", rows * columns - 2);
            walls = request_validation.inputNum("Введите количество стен: ", iScanner);
        }

        int startRow = request_validation.inputNum("Введите индекс строки старта. ", iScanner);
        while (!request_validation.isRigthIndex(startRow, rows)) {
            System.out.println("Номер строки не может быть больше количества строк.");
            System.out.printf("Введите число от 1 до %d.\n", rows);
            startRow = request_validation.inputNum("Введите номер строки: ", iScanner);
        }

        int startColumn = request_validation.inputNum("Введите индекс столбца старта. ", iScanner);
        while (!request_validation.isRigthIndex(startColumn, columns)) {
            System.out.println("Номер столбца не может быть больше количества столбцов.");
            System.out.printf("Введите число от 1 до %d.\n", columns);
            startColumn = request_validation.inputNum("Введите номер столбца: ", iScanner);
        }

        int finishRow = request_validation.inputNum("Введите индекс строки финиша. ", iScanner);
        while (!request_validation.isRigthIndex(finishRow, rows)) {
            System.out.println("Номер строки не может быть больше количества строк.");
            System.out.printf("Введите число от 1 до %d.\n", rows);
            finishRow = request_validation.inputNum("Введите номер строки: ", iScanner);
        }

        int finishColumn = request_validation.inputNum("Введите индекс столбца финиша. ", iScanner);
        while (!request_validation.isRigthIndex(finishColumn, columns)) {
            System.out.println("Номер столбца не может быть больше количества столбцов.");
            System.out.printf("Введите число от 1 до %d.\n", rows);
            finishColumn = request_validation.inputNum("Введите номер столбца: ", iScanner);
        }

        iScanner.close();

        int[][] field = methods.createField(rows, columns);
        methods.buildingWalls(field, walls);

        field[startRow][startColumn] = 1;
        field[finishRow][finishColumn] = -2;

        int[] finish = new int[]{finishRow, finishColumn};

        int step = methods.drawRoutes(field);
        System.out.println();

        if (request_validation.isRoute(field, finish)) {
            int[][] coordinates = methods.writingRoute(field, finish, step);
            methods.ReverseArray(coordinates);
            System.out.println();
            System.out.println("Пошаговый маршрут c координатами каждой точки: ");
            methods.show2dArrayWith2Col(coordinates);
            System.out.println();
            methods.elementsColoring(field, coordinates);
        } else {
            common_methods.show2dArray(field);
            System.out.println("Построить маршрут невозможно.");
        }
    }

}