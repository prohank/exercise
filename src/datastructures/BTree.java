package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BTree {
    private TreeNode root;

    public void add(int input) {
        root = addRecursive(input, root);
    }

    public TreeNode getRoot() {
        return root;
    }

    private TreeNode addRecursive(int input, TreeNode currentNode) {
        if (currentNode == null) {
            return new TreeNode(input);
        }
        if (input < currentNode.getData()) {
            currentNode.setLeft(addRecursive(input, currentNode.getLeft()));
        }
        if (input > currentNode.getData()) {
            currentNode.setRight(addRecursive(input, currentNode.getRight()));
        }
        return currentNode;
    }

    public void delete(int input) {
        root = deleteNodeRecursive(input, root);
    }

    private TreeNode deleteNodeRecursive(int input, TreeNode currentNode) {
        if (currentNode == null) return null;
        if (input == currentNode.getData()) {
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                return null;
            }
            if (currentNode.getLeft() == null) {
                return currentNode.getRight();
            }
            if (currentNode.getRight() == null) {
                return currentNode.getLeft();
            }
            int smallestValueOnRightSubTree = findSmallestValue(currentNode.getRight());
            currentNode.setData(smallestValueOnRightSubTree);
            currentNode.setRight(deleteNodeRecursive(smallestValueOnRightSubTree, currentNode.getRight()));
            return currentNode;

        }
        if (input < currentNode.getData()) {
            currentNode.setLeft(deleteNodeRecursive(input, currentNode.getLeft()));
            return currentNode;
        }
        if (input > currentNode.getData()) {
            currentNode.setRight(deleteNodeRecursive(input, currentNode.getRight()));
            return currentNode;
        }
        return currentNode;
    }

    private int findSmallestValue(TreeNode currentNode) {
        return currentNode.getLeft() == null ? currentNode.getData() : findSmallestValue(currentNode.getLeft());
    }

    public boolean search(int input) {
        return searchRecursive(input, root);
    }

    private boolean searchRecursive(int input, TreeNode currentNode) {
        if (currentNode == null) return false;
        if (input == currentNode.getData()) return true;
        if (input < currentNode.getData()) return searchRecursive(input, currentNode.getLeft());
        if (input > currentNode.getData()) return searchRecursive(input, currentNode.getRight());
        return false;
    }

    public void printDFSInOrder() {
        printDFSInOrderRecursive(root);
        System.out.println();
    }

    private void printDFSInOrderRecursive(TreeNode currentNode) {
        if (currentNode == null) return;
        printDFSInOrderRecursive(currentNode.getLeft());
        System.out.print(" " + currentNode.getData());
        printDFSInOrderRecursive(currentNode.getRight());
    }

    public void printBFS() {
        if (root == null) System.out.println();

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<TreeNode> childNodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode currentNode = nodes.remove();
            System.out.print(currentNode.getData()+"\t");
            if (null != currentNode.getLeft()) {
                childNodes.add(currentNode.getLeft());
            }
            if (null != currentNode.getRight()) {
                childNodes.add(currentNode.getRight());
            }
            if(nodes.isEmpty()){
                System.out.println();
                nodes.addAll(childNodes);
                childNodes.clear();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BTree btree = new BTree();
        btree.add(6);
        btree.add(3);
        btree.add(4);
        btree.add(1);
        btree.add(8);
        btree.add(9);
        btree.add(10);
        btree.add(1); //Duplicate element

        System.out.println("Printing in DFS: ");
        btree.printDFSInOrder();
        System.out.println("Printing in BFS: ");
        btree.printBFS();
        System.out.println("5 in tree: " + btree.search(5));
        System.out.println("10 in tree: " + btree.search(10));

        btree.delete(6);
        System.out.print("Printing in DFS: ");
        btree.printDFSInOrder();
        System.out.println("Root: " + btree.root.getData());

    }
}
