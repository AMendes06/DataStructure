package EstruturasList;

//Imports
import EstruturasNode.DoubleNode;
import java.util.NoSuchElementException;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class DoubleUnorderedLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

    /**
     * Creates an empty List.
     */
    public DoubleUnorderedLinkedList() {
        super();
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param element the element to be added to this list.
     */
    @Override
    public void addToFront(T element) {
        DoubleNode<T> node = new DoubleNode<>();
        node.setNext(super.head);
        node.setElement(element);

        super.head = node;
        super.count++;
    }

    /**
     * Adds an element to the rear of the list.
     *
     * @param element the element to be added to this list.
     */
    @Override
    public void addToRear(T element) {
        DoubleNode<T> node = new DoubleNode<>();
        node.setElement(element);

        if (isEmpty()) { //Adiciona a cabeça
            super.head = node;
        } else {
            DoubleNode<T> prev = super.head;

            while (prev.getNext() != null) {
                prev = prev.getNext();
            }

            node.setPrev(prev);
            prev.setNext(node);
        }

        super.count++;
    }

    /**
     * Adds an element after a particular element already in the list.
     *
     * @param element the element to be added to this list.
     * @param target the element target for add a new element.
     */
    @Override
    public void addAfter(T element, T target) throws NoSuchElementException {
        DoubleNode<T> newNode = new DoubleNode<>();
        newNode.setElement(element);

        if (isEmpty()) {                                  //verifica se está vazia
            super.head = newNode;
            super.count++;
        } else {

            DoubleNode<T> curr = super.head;
            boolean found = false;

            while (curr != null && !found) {                  //pesquisa na restante lista
                if (curr.getElement().equals(target)) {
                    found = true;
                } else {
                    curr = curr.getNext();
                }
            }

            if (found == false) {
                throw new NoSuchElementException();
            }

            if (curr != null) {
                newNode.setNext(curr.getNext());
                newNode.setPrev(curr);
                curr.setNext(newNode);
                super.count++;
            }

        }
    }
}