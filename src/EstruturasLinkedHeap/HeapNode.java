/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasLinkedHeap;

import EstruturasLinkedBinaryTree.BinaryTreeNode;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class HeapNode<T> extends BinaryTreeNode<T> {

    private HeapNode<T> parent;

    /**
     * Creates a new heap node with the specified data.
     *
     * @param obj the data to be contained within the new heap nodes
     */
    protected HeapNode(T obj) {
        super(obj);
        this.parent = null;
    }

    public HeapNode<T> getParent() {
        return this.parent;
    }

    public void setParent(HeapNode<T> parent) {
        this.parent = parent;
    }
    
    
}
