import java.util.Arrays;

// ArrayList
public class CustomArrayList<E> implements CustomList<E> { // массив с вспомогательными переменными; E - название дженерика
    private int size;
    private Object[] data;

    public CustomArrayList() {
        this(20);
    }

    // конструктор с начальной вместимостью
    public CustomArrayList(int initialCapacity) { // параметр - начальная вместимость
        data = new Object[initialCapacity];
        size = 0;
    }

    public void add(E value) {
        if (size >= data.length) {
            data = grow(data); // вызываем метод grow
        }
        data[size++] = value;
    }

    public E get(int index) { // запрашиваем эл-т по индексу
        return (E) data[index];
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= data.length) // проверка что индекс не выходит за границы
            throw new IndexOutOfBoundsException();
        size--; // уменьшение размера массива на 1
        E value = (E)data[index]; // возвращает удаляемый эл-т
        // перенос части массива справа от удаляемого эл-та влево
        System.arraycopy(data, index+1, data, index, size); // 1 - объект, из к-го значение получают; 2 - начальная позиция,
        // 3 - место назначения, 4 - место затираемого эл-та, 5 - размер массива
        return value;
    }

    private Object[] grow(Object[] oldArray) { // private - чтобы пользователь не мог сам изменить размер
        return Arrays.copyOf(oldArray, oldArray.length * 2); // 1 параметр - старый массив и 2 параметр - его размер
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(data) + '}';
    }
}


