import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Node o) {
            if(this.x < o.x)
                return -1;
            else if(this.x > o.x)
                return 1;
            else if(this.y > o.y)
                return 1;
            else
                return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            queue.add(new Node(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            bw.write(poll.x+" "+poll.y+"\n");
        }
        bw.flush();
        bw.close();
    }
}
