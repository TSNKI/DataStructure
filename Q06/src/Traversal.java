/**
 * Created by 曹利航 on 2016/11/21 11:05.
 */
public class Traversal<T> {
    public void preOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.element + " ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    public void inOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftChild);
        System.out.print(root.element + " ");
        inOrder(root.rightChild);
    }

    public void postOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.element + " ");
    }
}
