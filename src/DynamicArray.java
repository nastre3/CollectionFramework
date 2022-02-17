import java.util.Arrays;

public class DynamicArray { // массив с вспомогательными переменными
    private int size;
    private String[] data;

    public DynamicArray() {
        this(20);
    }

    // конструктор с начальной вместимостью
    public DynamicArray(int initialCapacity) { // параметр - начальная вместимость
        data = new String[initialCapacity];
        size = 0;
    }

    public void add(String value) {
        if (size>=data.length) {
            data = grow(data); // вызываем метод grow
        }
        data[size++] = value;
    }

    private String[] grow(String[] oldArray) { // private - чтобы пользователь не мог сам изменить размер
        return Arrays.copyOf(oldArray, oldArray.length*2); // 1 параметр - старый массив и 2 параметр - его размер
    }

    @Override
    public String toString() {
        return "{" +  Arrays.toString(data) + '}';
    }
}


