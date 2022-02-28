package competitive;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * Given a tree, return the average of values at each tree level
 */
public class AvgTree {

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(4);
        Node node4 = new Node(3);
        Node node5 = new Node(3);
        Node node6 = new Node(6);
        Node node7 = new Node(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(avgLevels(node1)); //[5,4,4]
    }

    public static List<Integer> avgLevels(Node root) {
        List<Integer> avgList = new ArrayList<>();
        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> subQ = new ArrayDeque<>();
        Node node = root;
        mainQ.add(node);
        avgList.add(root.value);
        while (!mainQ.isEmpty()) {
            while (!mainQ.isEmpty()) {
                node = mainQ.poll();
                if (node.left != null) {
                    subQ.add(node.left);
                }
                if (node.right != null) {
                    subQ.add(node.right);
                }
            }
            if (!subQ.isEmpty()) {
                int[] subLevelValues = new int[subQ.size()];
                for (int i = 0; i < subLevelValues.length; i++) {
                    subLevelValues[i] = subQ.peek().value;
                    mainQ.add(subQ.poll());
                }
                int avgResult = performAverage(subLevelValues);
                avgList.add(avgResult);
            }
        }
        return avgList;
    }

    private static int performAverage(int[] n) {
        int sum = 0;
        for (int i : n) {
            sum += i;
        }
        return sum / n.length;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int data) {
        this.value = data;
    }
}


