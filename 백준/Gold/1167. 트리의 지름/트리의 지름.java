import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int end;
        int value;
        public Edge(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }
    static int[] dist;
    static ArrayList<Edge>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<Edge>();
        }
        dist = new int[N+1];
        Arrays.fill(dist, -1);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int nextNode;
            int nextValue;
            while(true) {
                nextNode = Integer.parseInt(st.nextToken());
                if(nextNode == -1)
                    break;
                nextValue = Integer.parseInt(st.nextToken());
                tree[node].add(new Edge(nextNode,nextValue));
            }
        }
        bfs(1);
        int maxIndex = 0;
        for (int i = 0; i < N + 1; i++) {
            if(dist[maxIndex] < dist[i])
                maxIndex = i;
        }
        Arrays.fill(dist, -1);
        bfs(maxIndex);
        int result = 0;
        for (int i = 0; i < N + 1; i++) {
            result = Math.max(result, dist[i]);
        }
        System.out.println(result);
    }
    static void bfs(int start) {
        Queue<Edge> queue = new ArrayDeque<>();
        dist[start] = 0;
        for(Edge next : tree[start]) {
            dist[next.end] = next.value;
            queue.add(next);
        }
        while(!queue.isEmpty()) {
            Edge poll = queue.poll();
            for(Edge next : tree[poll.end]) {
                if(dist[next.end] == -1) {
                    dist[next.end] = poll.value + next.value;
                    queue.add(new Edge(next.end, dist[next.end]));
                }
            }
        }
    }
}