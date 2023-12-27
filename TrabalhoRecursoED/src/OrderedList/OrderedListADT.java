/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package OrderedList;

import List.ListADT;
import Exceptions.EmptyCollectionException;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public interface OrderedListADT<T> extends ListADT<T>{
    /**
     * Adds the specified element to this list at the proper location
     *
     * @param element the element to be added to this list
     */
    public void add(T element) throws EmptyCollectionException;
}

