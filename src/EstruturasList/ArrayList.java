/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasList;

//Imports
import EstruturasList.ListADT;
import Exceptions.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class ArrayList<T> implements ListADT<T> {

    //Contador
    protected int count;

    //Lista frente do array e o 0
    protected T[] list;
    /**
     * constant to represent the default capacity of the array
     */
    protected final int DEFAULT_CAPACITY = 100;

    protected int modCount;
    
    /**
     * Constructor
    */
    public ArrayList() {
        this.count = 0;
        this.modCount = 0;
        this.list = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Remove First
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        //Verifica se esta vazio
        if (this.isEmpty()) {
            throw new EmptyCollectionException("List");
        }

        //Elemento a remover
        T target = this.list[0];
        this.shiftRemove(0);
        this.count--;

        this.modCount++;

        return target;
    }

    /**
     * Remove Last
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("List");
        }
        this.count--;
        T element = this.list[this.count];
        this.list[this.count] = null;

        this.modCount++;

        return element;
    }

    /**
     * Remove
     *
     * @param element
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T remove(T element) throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Empty List");
        }
        T target = null;
        int index = this.getElementIndex(element);

        if (index > -1) {
            target = this.list[index];
            this.shiftRemove(index);
            this.count--;

            this.modCount++;

        }
        return target;
    }

    /**
     * First
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Empty List");
        }

        return this.list[0];
    }

    /**
     * Last
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Empty List");
        }

        return this.list[this.count - 1];
    }

    /**
     * Contains
     *
     * @param target
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public boolean contains(T target) throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Empty List");
        }

        return this.getElementIndex(target) > -1;
    }

    /**
     * Is Empry
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Size
     *
     * @return
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Iterator
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    /**
     * To String
     *
     * @return
     */
    @Override
    public String toString() {
        String output = "";

        Iterator iter = this.iterator();
        while (iter.hasNext()) {
            output += iter.next() + "\n";
        }
        return output;
    }

    /**
     * Get Element Index
     *
     * @param element
     * @return
     */
    protected int getElementIndex(T element) {
        int index = -1;
        for (int i = 0; i < this.count; i++) {
            if (this.list[i].equals(element)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Shifts the elements from the array when it's removing an element from it
     *
     * @param index index of the element in the list
     */
    private void shiftRemove(int index) {
        //size represents the array size ignoring the element to remove
        int size = this.count - 1;

        for (int i = index; i < size; i++) {
            this.list[i] = this.list[i + 1];
        }
        this.list[this.count] = null;
    }

    /**
     * Iterator
     */
    private class Iter implements Iterator<T> {

        //Variables
        private int cursor;
        private int expectedModCount;

        /**
         * Iterator
         */
        Iter() {
            this.cursor = 0;
            this.expectedModCount = modCount;
        }

        /**
         * HasNext
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            return this.cursor < size();
        }

        /**
         * Next
         *
         * @return
         */
        @Override
        public T next() {
            checkForModification();

            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }

            this.cursor++;

            return list[this.cursor - 1];
        }

        /**
         * Remove
         */
        @Override
        public void remove() {
            checkForModification();

            try {
                ArrayList.this.remove(next());
            } catch (EmptyCollectionException ex) {
                throw new IllegalStateException();
            }

            this.expectedModCount++;

        }

        /**
         * Check for Modification
         */
        private void checkForModification() {
            if (modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

    }

}