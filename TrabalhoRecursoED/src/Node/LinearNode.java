package Node;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class LinearNode<T> {

    private LinearNode<T> next;
    private T element;

    /**
     * Permite criar um LinearNode vazio
     */
    public LinearNode() {
        this.element = null;
        this.next = null;
    }

    /**
     * Permite criar um LinearNode com elemento definido
     *
     * @param element elemento do Linear Node
     */
    public LinearNode(T element) {
        this.next = null;
        this.element = element;
    }

    /**
     *
     * @return o próximo LinearNode
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Permite alterar o próximo LinearNode
     *
     * @param node novo next para o LinearNode
     */
    public void setNext(LinearNode<T> node) {
        this.next = node;
    }

    /**
     * Permite obter o elemento do LinearNode
     *
     * @return elemento do LinearNode
     */
    public T getElement() {
        return element;
    }

    /**
     * Permite alterar o elemento do LinearNode
     *
     * @param elemento novo elemento do LinearNode
     */
    public void setElement(T elemento) {
        this.element = elemento;
    }
}
