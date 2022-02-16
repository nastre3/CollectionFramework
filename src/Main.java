import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int capacity = 20;
        int size = 0;
        String[] toDoList = new String[capacity]; // реализация на основе массива (нельзя увеличить размер массива)
        Scanner sc = new Scanner(System.in); // ввод данных в консоль

        int choice = 3;
        do {
            System.out.println("1. Add to do\n2. Show all\n3. Exit");
            choice = sc.nextInt(); // считываем выбор пользователя из консоли
            if (choice == 1) {
                System.out.println("Enter new ToDo");
                sc.nextLine(); // очистка буфера для работы сканнера
                toDoList[size++] = sc.nextLine(); // запись в массив
            } else if (choice == 2) {
                System.out.println(Arrays.toString(toDoList)); // вывод эл-ов массива
            }
        } while (choice != 3);
    }
}
