import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DynamicArray toDoList = new DynamicArray(2); // реализация на основе массива (нельзя увеличить размер массива)
        Scanner sc = new Scanner(System.in); // ввод данных в консоль

        int choice = 3;
        do {
            System.out.println("1. Add to do\n2. Show all\n3. Exit");
            choice = sc.nextInt(); // считываем выбор пользователя из консоли
            if (choice == 1) {
                System.out.println("Enter new ToDo");
                sc.nextLine(); // очистка буфера для работы сканнера
                toDoList.add(sc.nextLine());
            } else if (choice == 2) {
                System.out.println(toDoList); // вывод эл-ов массива
            }
        } while (choice != 3);
    }

    public static String[] growArray(String[] oldArray) {
        /* 1 вариант увеличить размерность массива
        String[] newArray = new String[oldArray.length*2];// увеличение размера массива = старого в 2 раза
        // newArray = oldArray; // неверно, тк размер не ув-ся, а скопируется ссылка
        for (int i = 0; i < oldArray.length; i++) { // пройтись по всем эл-ам старого массива и засунуть его в новый
            newArray[i] = oldArray[i];
        }
        return newArray;
        */
        // 2 вариант увеличить размерность массива
        return Arrays.copyOf(oldArray, oldArray.length*2); // 1 параметр - старый массив и 2 параметр - его размер
    }


}
