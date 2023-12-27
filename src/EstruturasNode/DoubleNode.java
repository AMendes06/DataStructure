package EstruturasNode;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */

public class DoubleNode<T> {
    
    /**
     * Element {@link DoubleNode}.
     */
    private T element;
    
    /**
     * Next {@link DoubleNode}.
     */
    private DoubleNode<T> next;
    
    /**
     * Previous {@link DoubleNode}.
     */
    private DoubleNode<T> prev;
    
    /**
     * Inicialize {@link DoubleNode} 
     */
    public DoubleNode(){
        this.element = null;
        this.next = null;
        this.prev = null;
    }

    /**
     * Retorne the {@link DoubleNode#element} from {@link DoubleNode}. 
     * @return Element.
     */
    public T getElement() {
        return element;
    }

    /**
     * Set the {@link DoubleNode#element} from {@link DoubleNode}.
     * @param element Element.
     */
    public void setElement(T element) {
        this.element = element;
    }
    
    /**
     * Retorne the {@link DoubleNode#next} from {@link DoubleNode}.
     * @return Next {@link DoubleNode}.
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Set the {@link DoubleNode#next} from {@link DoubleNode}.
     * @param next Next {@link DoubleNode}.
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Retorne the {@link DoubleNode#prev} from {@link DoubleNode}. 
     * @return Previous {@link DoubleNode}.
     */
    public DoubleNode<T> getPrev() {
        return prev;
    }

    /**
     * Set the {@link DoubleNode#prev} from {@link DoubleNode}.
     * @param prev Previous {@link DoubleNode}.
     */
    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }
    
}