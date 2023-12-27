package EstruturasList;

//Imports
import Exceptions.EmptyCollectionException;
import EstruturasNode.DoubleNode;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class DoubleLinkedList<T> implements ListADT<T>, Iterable<T> {

    /**
     * Head {@link DoubleLinkedList}
     */
    protected DoubleNode<T> head;
    /**
     * Size {@link DoubleLinkedList}
     */
    protected int count;

    /**
     * Inicialize {@link DoubleLinkedList}
     */
    public DoubleLinkedList() {
        this.head = null;
        this.count = 0;
    }

    /**
     * Find element and remove from the Double Linked List.
     *
     * @param element Element for eliminate.
     * @return Element eliminated.
     * @throws EmptyCollectionException Generate one exception if the Double
     * Linked List is empty.
     * @throws Collections.Exceptions.NoSuchElementException Generate one
     * exception if the element don't exists.
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, NoSuchElementException {

        if (this.isEmpty()) {
            throw new EmptyCollectionException("Double Linked List");
        }

        DoubleNode<T> del = this.posDelete(this.head, element);
        
        if (del == null) {
            throw new NoSuchElementException();
        }
        
        if(del == this.head){           //Delete in head
            if(del.getNext() != null){
                del.getNext().setPrev(null);
            }
            this.head = del.getNext();
        } else {                        //Delete in the middle
            del.getPrev().setNext(del.getNext());
            if(del.getNext() != null){
                del.getNext().setPrev(del.getPrev());
            }
        }
        this.count--;
        return del.getElement();
    }
    /**
     * Search position about element for Delete.
     * @param pHead Head.
     * @param elem Element.
     * @return BiNode.
     */
    private DoubleNode<T> posDelete(DoubleNode pHead, T elem){
        DoubleNode<T> actual = pHead;
        
        while(actual != null && elem.equals(actual.getElement()) != true){
            actual = actual.getNext();
        }
        return actual;
    }
    /**
     * Remove the first element.
     * @return Element eliminated.
     * @throws Collections.Exceptions.EmptyCollectionException Generate one exception if
     * the List is empty.
     */
    @Override
    public T removeFirst() throws EmptyCollectionException{
        
        if(this.isEmpty()){                              
            throw new EmptyCollectionException("Double Linked List");
        } 

        T elem = this.head.getElement();

        if(this.count == 1){    
            
            this.head = null;
        } else {
        
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }
            
        this.count--;
        return elem;
    }

    /**
     * Remove the last element.
     *
     * @return Element eliminated.
     * @throws Collections.Exceptions.EmptyCollectionException Generate one
     * exception if the List is empty.
     */
    @Override
    public T removeLast() throws EmptyCollectionException {

        if (this.isEmpty()) {

            throw new EmptyCollectionException("Double Linked List");
        }

        T elem;

        if (this.count == 1) {

            elem = this.head.getElement();
            this.head = null;

        } else {                                //remove na cauda
            DoubleNode<T> no = this.head;

            while (no.getNext() != null) {
                no = no.getNext();
            }

            DoubleNode<T> prev = no.getPrev();
            prev.setNext(null);

            elem = no.getElement();
        }

        this.count--;
        return elem;
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

        if (this.isEmpty()) {

            throw new EmptyCollectionException("Double Linked List");
        }

        DoubleNode<T> node = this.head;

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

        if (this.isEmpty()) {

            throw new EmptyCollectionException("Double Linked List");
        }

        return this.head.getElement();
    }

    /**
     * Verify if Double Linked List is empty.
     *
     * @return true if is empty or false isn't.
     */
    @Override
    public boolean isEmpty() {

        return this.count == 0;
    }

    /**
     * Size of Double Linked List.
     *
     * @return How many elements have the Double Linked List.
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Iterator for Double Linked List.
     *
     * @return Iterator with elements from Double Linked List.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public boolean contains(T target) throws EmptyCollectionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private class MyIterator implements Iterator<T> {

        private DoubleNode<T> current;
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
                    throw new NoSuchElementException();
                } catch (NoSuchElementException ex) {
                    Logger.getLogger(DoubleLinkedList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            ++this.modCount;

            DoubleNode node = current;
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

                DoubleLinkedList.this.remove(elem);
            } catch (EmptyCollectionException | NoSuchElementException ex) {
                Logger.getLogger(DoubleLinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Represents a string from the Double Linked List.
     *
     * @return String with elements from Double Linked List.
     */
    @Override
    public String toString() {
        DoubleNode<T> curr = this.head;
        String result = "";

        while (curr != null) {
            result = result + (curr.getElement()).toString() + "\n";
            curr = curr.getNext();
        }
        return result;
    }

    public DoubleNode<T> getHead() {
        return head;
    }

    public void setHead(DoubleNode<T> head) {
        this.head = head;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
