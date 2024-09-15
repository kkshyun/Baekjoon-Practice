import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Node> deque = new LinkedList<>();
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int L = Integer.parseInt(str[1]);
        int[] numArr = new int[N];
        int[] result = new int[N];
        str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(str[i]);
        }

        for(int i = 0 ; i < N ; i++) {
            while (!deque.isEmpty() && deque.getLast().value >= numArr[i]) {
                deque.removeLast();
            }
            deque.addLast(new Node(numArr[i], i));

            while(deque.getFirst().index<=i-L) {
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");
        }
        
        bw.flush();
        bw.close();
    }
    
    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}