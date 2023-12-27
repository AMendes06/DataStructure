package List;

import Exceptions.EmptyCollectionException;
import Node.LinearNode;
import java.util.Iterator;
import Exceptions.NoSuchElementExecpetion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class LinkedList<T> implements ListADT<T>, Iterable<T> {

    /**
     * Head {@link LinkedList}.
     */
    private LinearNode<T> head;
    /**
     * Size {@link LinkedList}.
     */
    private int count;

    /**
     * Inicialize {@link LinkedList} to null.
     */
    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    /**
     * Inicilize with a new element {@link LinkedList}.
     *
     * @param element Element.
     */
    public LinkedList(T element) {
        this.head.setElement(element);
        this.count++;
    }

    /**
     * Remove the first element.
     *
     * @return Element eliminated.
     * @throws Collections.Exceptions.EmptyCollectionException Retorne exception
     * if the list is empty.
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (this.count == 0) {
            throw new EmptyCollectionException("List");
        }

        T element = this.head.getElement();

        this.head = this.head.getNext();
        this.count--;

        return element;
    }

    /**
     * Remove the last element.
     *
     * @return Element eliminated.
     * @throws Collections.Exceptions.EmptyCollectionException Retorne exception
     * if the list is empty.
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (this.count == 0) {
            throw new EmptyCollectionException("List");
        }

        LinearNode<T> node = this.head;

        while (node.getNext() != null) {
            node = node.getNext();
        }

        T element = node.getElement();

        node = null;
        this.count--;

        return element;
    }

    /**
     * Search element into List and remove.
     *
     * @param element Element.
     * @return 
     * @throws Exceptions.EmptyCollectionException
     * @throws Exceptions.NoSuchElementExecpetion
     */
    
    @Override
    public T remove(T element) throws EmptyCollectionException, NoSuchElementExecpetion {

        if (this.count == 0) {
            throw new EmptyCollectionException("List");
        }

        if (this.count == 1 && this.head.getElement().equals(element)) {
            this.head = null;
        }

        LinearNode<T> curr = this.head;
        LinearNode<T> prev = new LinearNode<>();

        boolean found = false;

        while (curr != null && !found) {

            if (curr.getElement().equals(element)) {
                found = true;
            } else {
                prev = curr;
                curr = curr.getNext();
            }
        }

        if (curr == null) {
            throw new NoSuchElementExecpetion();
        } else {
            prev.setNext(curr.getNext());
            return curr.getElement();
        }
    }

    /**
     * Last element.
     *
     * @return element.
     * @throws EmptyCollectionException Generate one exception if the List is
     * empty.
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (this.count == 0) {
            throw new EmptyCollectionException("List");
        }

        LinearNode<T> node = this.head;

        while (node.getNext() != null) {
            node = node.getNext();
        }

        return node.getElement();
    }

    /**
     * First element.
     *
     * @return element.
     * @throws EmptyCollectionException Generate one exception if the List is
     * empty.
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (this.count == 0) {
            throw new EmptyCollectionException("List");
        }

        return this.head.getElement();
    }

    /**
     * Verify if List is empty.
     *
     * @return true if is empty or false isn't.
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Size of List.
     *
     * @return How many elements have the List.
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Iterator for List.
     *
     * @return Iterator with elements from List.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Represents a string from the List.
     *
     * @return String with elements from List.
     */
    @Override
    public String toString() {
        LinearNode<T> curr = this.head;
        String result = "";

        while (curr != null) {
            result = result + (curr.getElement()).toString() + "\n";
            curr = curr.getNext();
        }
        return result;
    }

    public void setHead(LinearNode<T> head) {
        this.head = head;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean contains(T target) throws EmptyCollectionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private class MyIterator implements Iterator<T> {

        private LinearNode<T> current;
        private int modCount;
        private boolean okToRemove;

        public MyIterator() {
            this.current = head;
            this.modCount = 0;
            this.okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public T next() {

            if (!hasNext()) {
                try {
                    throw new NoSuchElementExecpetion();
                } catch (NoSuchElementExecpetion ex) {
                    Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            ++this.modCount;

            LinearNode node = current;
            current = current.getNext();

            return (T) node.getElement();
        }

        @Override
        public void remove() throws UnsupportedOperationException {

            if (!this.okToRemove) {
                throw new IllegalStateException();
            }

            this.okToRemove = false;
            --this.modCount;

            T elem = (T) current.getElement();

            try {

                LinkedList.this.remove(elem);
            } catch (EmptyCollectionException | NoSuchElementExecpetion ex) {
                Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public LinearNode<T> getHead() {
        return head;
    }

    public int getCount() {
        return count;
    }

}
