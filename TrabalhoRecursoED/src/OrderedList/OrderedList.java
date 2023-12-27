/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrderedList;

import List.ArrayList;
import Exceptions.EmptyCollectionException;
import Exceptions.NotComparable;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */

public class OrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

    ///public OrderedList(int tamanho) {
       // super(tamanho);
    //}

  

    @Override
    public void add(T element) throws EmptyCollectionException {
        if (this.list.length == size()) {
            expandList();
        }
        
        if (element instanceof Comparable) {
            if (isEmpty()) {
                this.list[0] = element;
            } else {
                
                Comparable lastPosition = (Comparable) this.list[count - 1];
                
                if (lastPosition.compareTo(element) < 0) {
                    list[count] = element;
                } else {
                    boolean found = false;
                    int current = 0;
                    
                    while (current < size() && found == false) {
                        Comparable<T> tmp = (Comparable<T>) list[current];
                        if (tmp.compareTo(element) > 0) {
                            found = true;
                        } else {
                            current++;
                        }
                    }
                    
                    //Shift da ultima posição para a primeira
                    if (found == true) {
                        for (int i = count - 1; i >= current; i--) {
                            list[i + 1] = list[i];
                        }
                        list[current] = element;
                    }
                }
            }
            
            count++;
            modCount++;
            
        } else {
            throw new EmptyCollectionException("O elemento não é instancia de comparable!");
        }
    }
    
    private void expandList() {
        T[] tmp = (T[]) new Object[list.length + DEFAULT_CAPACITY];
        
        for (int i = 0; i < size(); i++) {
            tmp[i] = list[i];
        }
        
        list = tmp;
    } 
}