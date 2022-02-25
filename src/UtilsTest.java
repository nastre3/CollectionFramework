import java.util.*;

public class UtilsTest {
    public static void main(String[] args) {
        TreeSet<Pet> pets = new TreeSet<>(new Comparator<Pet>() { // 2 способ - сравнение с помощью компоратора
            @Override
            public int compare(Pet o1, Pet o2) {
                return o2.age - o1.age; // сортировка в порядке убывания возраста
            }
        });
        pets.add(new Pet(12));
        pets.add(new Pet(10));
        System.out.println(pets);

        CollectionUtils.printList(new LinkedList<Object>());
        CollectionUtils.printList(new LinkedList<Number>()); //Number - "васал моего вассала не мой вассал", если в printList List<Object>
        CollectionUtils.printList(new LinkedList<String>()); //Number - "васал моего вассала не мой вассал", если в printList List<Object>
        CollectionUtils.printList(new LinkedList<ArrayList<String>>()); //Number - "васал моего вассала не мой вассал", если в printList List<Object>

        CollectionUtils.insertNumbers(new LinkedList<Number>());
        CollectionUtils.insertNumbers(new LinkedList<Integer>());
        CollectionUtils.insertNumbers(new LinkedList<Object>());
    }
}

class Pet /*implements Comparable<Pet> */{
    public int age;

    public Pet(int age) {
        this.age = age;
    }

/*
    @Override
    public int compareTo(Pet o) { // + - объект больше, чем переданный, 0 - равны
        return age - o.age; // cортировка по возрастанию
    }
 */

    @Override
    public String toString() {
        return "Pet{" +
                "age=" + age +
                '}';
    }
}
