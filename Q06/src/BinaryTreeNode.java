/**
 * Created by 曹利航 on 2016/11/21 11:06.
 */
public class BinaryTreeNode<T> {
    T element;
    BinaryTreeNode<T> leftChild;
    BinaryTreeNode<T> rightChild;

    public BinaryTreeNode() {
        element = null;
        leftChild = null;
        rightChild = null;
    }

    public BinaryTreeNode(T element, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
