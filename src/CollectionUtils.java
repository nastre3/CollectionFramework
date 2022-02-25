import java.util.List;

public class CollectionUtils {
    public static void printList(List<?> list) { // параметр - листы любого типа
        for (Object o : list) {
            System.out.println(o);
        }
    }

    // недопустимо выше Number, например "Object"
    public static void printListSum(List<? extends Number> list) { // Upper Bounded Wildcards - верхние границы ставятся для чтения из структуры
        int val = 0;
        for (Number o : list) { // подсчет суммы эл-ов списка в цикле
            val+=o.intValue();
        }
    }

    // недопустимо ниже Integer, выше допустимо, например "Number", "Object"
    public static void insertNumbers(List<? super Integer> list) { // Lower Bounded Wildcards - нижние границы для записи
        for (int i = 0; i < 10; i++) {
            list.add(i);
            // list.add("a"); // вставка строки недопустима
        }
    }
}
