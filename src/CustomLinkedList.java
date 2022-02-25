public class CustomLinkedList<E> implements CustomList<E> {

    int size = 0;
    Node<E> first;

    @Override
    public void add(E value) {
        Node<E> last = first; // указатель на последний эл-т
        if (last == null) { // список пустой
            first = new Node<>(null, value, null); // создаем новую node c предыдущим и послед-им эл-ми = null
        } else {
            while (last.next != null) { // пока не дойдем до послед.эл-та
                last = last.next; // перебор эл-ов по последнего
                last.next =  new Node<>(last, value, null); // создание новых нод. Ссылка на последний эл-т
            }
        }
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public E remove(int index) {
        Node<E> x = node(index); // нода для удаления
        // ссылки на след, предыд. ноды
        Node<E> next = x.next;
        Node<E> prev = x.prev;
        E value = x.item;
        // удаление эл-та
        if (prev==null) { // эл-т один
            first = next;
        } else { // если предыдущий эл-т был
            prev.next = next; // пропуск удаляемого эл-та
            x.prev = null;
        }
        if (next !=null) { // для послед. эл-ов
            next.next = prev;
            x.next = null; // удаление лишней ссылки для помощи garbage collector
        }
        size--;
        return value; // возврат значения после удаления
    }

    private Node<E> node(int index) { // перебор нод
        Node<E> x = first; // неизвестная нода
        for (int i = 0; i < index; i++) {
            x = x.next; // получение след. эл-та
        }
        return x; // возврат ноды
    }

    // вложенный статический класс
    private static class Node<E> { // узел структуры c дженериком для хранения данных
        // ссылки на след. и предыдущ-ий эл-ты и item
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        // для отображения всего нужно пройтись по всем эл-ам
        StringBuilder sb = new StringBuilder("{");
        Node<E> cur = first;
        while (cur!=null) {
            sb.append(cur.item).append(","); // добавляем значение эл-та c запятой
            cur = cur.next; // переносим указатель на след эл-т
        }
        sb.append("}");
        return sb.toString();
    }
}
