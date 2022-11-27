package task_9;

/**
 * My own implementation of Queue collection
 * - add(T element)
 * - peek()
 * - poll()
 * - clear() - in the Nodes class
 * - size() - in the Nodes class
 * - toString() - in the Nodes class
 *
 * @param <T> generic types of allowed elements
 */
public class MyQueue <T> extends Nodes<T> {

    public void add(T value) {
        //додає елемент в кінець

    }
    /**
     * Method returns the size of the queue
     * @return list size
     */
    public int size(){
        return size;
    }
    public T peek() {
       // повертає перший елемент з черги
        return null;
    }
    public T poll(){
        return null;
        //повертає перший елемент з черги і видаляє його з колекції
    }

}
