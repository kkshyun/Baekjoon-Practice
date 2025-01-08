import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    static int result, K, N;
    static int[] dist, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        dist = new int[200001];
        visited = new int[200001];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[N] = 0;
        dijkstra(N);
        System.out.println(result);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        queue.add(new Node(start,0));
        while(!queue.isEmpty()) {
            Node poll = queue.poll();

            if(poll.end == K) {
                result = poll.cost;
                return;
            }
            if(visited[poll.end]==1)
                continue;
            visited[poll.end] = 1;

            if(poll.end+1<dist.length&&dist[poll.end+1]>dist[poll.end]+1) {
                dist[poll.end+1] = dist[poll.end]+1;
                queue.add(new Node(poll.end+1,dist[poll.end+1]));
            }
            if(poll.end-1>=0&&dist[poll.end-1]>dist[poll.end]+1) {
                dist[poll.end-1] = dist[poll.end]+1;
                queue.add(new Node(poll.end-1,dist[poll.end-1]));
            }
            if(poll.end*2<dist.length&&dist[poll.end*2]>dist[poll.end]) {
                dist[poll.end*2] = dist[poll.end];
                queue.add(new Node(poll.end*2,dist[poll.end*2]));
            }
        }
    }
}