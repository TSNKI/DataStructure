/**
 * Created by 曹利航 on 2016/11/21 11:14.
 */
public class Main {
    public static void main(String[] args) {
        // Using the Binary Tree in Page 87 in file "chapter4.0_Tree.pdf".
        BinaryTreeNode<Character> root = new BinaryTreeNode<>('A', null, null);
        root.leftChild = new BinaryTreeNode<Character>('B', new BinaryTreeNode<Character>('D', null, null), null);
        root.rightChild = new BinaryTreeNode<Character>('C', null, null);
        root.rightChild.leftChild = new BinaryTreeNode<Character>('E', null, new BinaryTreeNode<Character>('G', null, null));
        root.rightChild.rightChild = new BinaryTreeNode<Character>('F', new BinaryTreeNode<Character>('H', null, null), new BinaryTreeNode<Character>('J', null, null));

        Traversal<Character> t=new Traversal<>();
        t.preOrder(root);
        System.out.println();
        t.inOrder(root);
        System.out.println();
        t.postOrder(root);
        System.out.println();

    }
}
