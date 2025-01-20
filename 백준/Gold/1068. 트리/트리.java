import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static Node root;
    static int count=0;
    static class Node{
        int data;
        List<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new LinkedList<>();
        }
    }

    public static void createNode(int data, int parentData, Node[] nodes) {
        if(parentData==-1) {
            root = nodes[data];
        }
        else
            nodes[parentData].children.add(nodes[data]);
    }

    public static void countLeaf(Node node, int deleteNode) {
        if(node == null || node.data == deleteNode) return;

        boolean isLeaf = true;
        for(Node child : node.children) {
            if(child.data != deleteNode) {
                isLeaf = false;
                countLeaf(child, deleteNode);
            }
        }
        if(isLeaf)
            count++;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }
        int rootIndex = -1;
        for (int i = 0; i < s.length; i++) {
            if(s[i].equals("-1")) {
                rootIndex = i;
                break;
            }
        }
        createNode(rootIndex,-1,nodes);

        for (int i = 0; i < N; i++) {
            if(i == rootIndex)
                continue;
            int parent = Integer.parseInt(s[i]);
            createNode(i,parent,nodes);
        }

        int deleteNode = Integer.parseInt(br.readLine());
        count = 0;
        countLeaf(root, deleteNode);
        System.out.println(count);
    }
}