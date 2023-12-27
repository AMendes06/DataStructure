/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

//Imports
import java.util.NoSuchElementException;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 * @param <T>
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {
    
    /**
     * Add to Front
     * @param element 
     */
    @Override
    public void addToFront(T element) {
        if (super.count == super.list.length) {
            this.expandCapacity();
        }

        this.shiftAddToFront(element);

        super.count++;
        super.modCount++;
    }
    
    /**
     * Add to Rear
     * @param element 
     */
    @Override
    public void addToRear(T element) {
        if (super.count == super.list.length) {
            this.expandCapacity();
        }

        super.list[this.count] = element;

        super.count++;
        super.modCount++;
    }
    
    /**
     * Add After
     * @param element
     * @param target
     * @throws NoSuchElementException 
     */
    @Override
    public void addAfter(T element, T target) throws NoSuchElementException {

        int index = super.getElementIndex(target);

        if (index < 0) {
            throw new NoSuchElementException("Target element not in the list");
        }

        if (super.count == super.list.length) {
            this.expandCapacity();
        }

        this.shiftAdd(index, element);

        super.count++;
        super.modCount++;
    }
    
    /**
     * Expand Capacity
     */
    private void expandCapacity() {
        T[] newList = (T[]) (new Object[super.list.length * 2]);
        System.arraycopy(super.list, 0, newList, 0, super.list.length);
        super.list = newList;
    }
    
    /**
     * Shift add to Front
     * @param element 
     */
    private void shiftAddToFront(T element) {
        int rear = super.count - 1;
        for (int i = rear; i >= 0; i--) {
            super.list[i + 1] = super.list[i];
        }
        super.list[0] = element;
    }
    
    /**
     * Shift Add
     * @param index
     * @param element 
     */
    private void shiftAdd(int index, T element) {
        int rear = super.count - 1;
        for (int i = rear; i >= index; i--) {
            super.list[i + 1] = super.list[i];
        }
        super.list[index] = element;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T[] getList() {
        return list;
    }

    public void setList(T[] list) {
        this.list = list;
    }

    public int getModCount() {
        return modCount;
    }

    public void setModCount(int modCount) {
        this.modCount = modCount;
    }
    
    

}
