import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Node root;
    static class Node {
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data = data;
        }
    }

    public static void createNode(String data, String leftData, String rightData) {
        if(root == null) {
            root = new Node(data);
            if(!leftData.equals("."))
                root.left = new Node(leftData);
            if(!rightData.equals("."))
                root.right = new Node(rightData);
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public static void searchNode(Node node, String data, String leftData, String rightData) {
        if(node == null)
            return;
        if(node.data.equals(data)) {
            if(!leftData.equals("."))
                node.left = new Node(leftData);
            if(!rightData.equals("."))
                node.right = new Node(rightData);
        }else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    static public void preOrder(Node node) {
        if(node == null)
            return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static public void inOrder(Node node) {
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    static public void postOrder(Node node) {
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        root = new Node("A");
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            createNode(s[0],s[1],s[2]);
        }
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
}