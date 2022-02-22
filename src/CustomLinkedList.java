public class CustomLinkedList<E> implements CustomList<E>{
    @Override
    public void add(E value) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    // вложенный статический класс
    private static class Node<E> { // узел структуры c дженериком для хранения данных
        // ссылки на след. и предыдущ-ий эл-ты и item
        E item;
        Node<E> next;
        Node<E> prev;


    }
}
