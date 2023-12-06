/**
 * HEIG-VD
 * Laboratoire 6 - Calculatrice
 * @author Ahmad Jano & Richard Aurélien
 * @date 06.12.2023
 */

package util;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack Class.
 * Used to stack values using nodes
 * @param <T> - Type of data to be stored
 */
public class Stack<T> implements Iterable<T>{

    private Node<T> top;
    private int size;

    /**
     * Push a new node on top of the Stack
     * @param item - Item to be pushed
     */
    public void push(T item){
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Removes the top item of the stack and return it
     * @return T - removed item
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty stack");
        }
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    /**
     * Return a formatted string with the content of the stack
     * @return String - content of stack in string form
     */
    public String toString(){
        StringBuilder result = new StringBuilder("[");
        Node<T> current = top;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    /**
     * Return an array of all array order by top to bottom (top is index 0)
     * @return T[] - an array of all items
     */
    public T[] toArray(T[] array) {
        Node<T> current = top;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    /**
     * Iterator to iterate on Nodes
     * @return Iterator<T>
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = top;

            /**
             * Returns whether there is a Node next
             * @return boolean
             */
            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            /**
             * Goes to the next Node and returns the data of the current one
             * @return T - data of current node
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = current.data;
                current = current.next;
                return item;
            }
        };
    }

    /**
     * Returns whether the stack is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the stack.
     * @return int
     */
    public int size(){
        return this.size;
    }

    /**
     * Node Class to be used in the stack
     * @param <T> - type of data
     */
    private static class Node<T> {
        private final T data;
        private Node<T> next;

        /**
         * Creates a new Node with the given data
         * @param data - Data of type T
         */
        private Node(T data) {
            this.data = data;
        }
    }
}
