import java.sql.Array;
import java.util.*;

public class App {

    public static void main(String[] args) {
        System.out.println("1.Use LinkedList\n2.Use ArrayList");
        HashMap<String, String> map = new HashMap<>();
        map.put("File", "Filename");

        Scanner sc = new Scanner(System.in); // ввод данных в консоль
        CustomList<String> toDoList = switch(sc.nextLine()) {
            case "1" -> new CustomLinkedList<>();
            default -> new CustomArrayList<>(); // заранее выд-ся больше памяти. ArrayList идентичен классу Vector
        };

        int choice = 3;
        do {
            System.out.println("1. Add to do\n2. Show all\n3. Delete item\n4.Exit");
            choice = sc.nextInt(); // считываем выбор пользователя из консоли
            if (choice == 1) {
                System.out.println("Enter new ToDo");
                sc.nextLine(); // очистка буфера для работы сканнера
                toDoList.add(sc.nextLine());
            } else if (choice == 2) {
                System.out.println(toDoList); // вывод эл-ов массива
            } else if (choice == 3) {
                toDoList.remove(sc.nextInt()); // удаление эл-та массива
            }
        } while (choice != 4);
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
