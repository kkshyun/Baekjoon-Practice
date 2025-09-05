import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static class Node {
        int end;
        int cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    public static boolean[] visited;
    public static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new  BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int d = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            ArrayList<Node>[] graph = new ArrayList[n+1];
            for (int j = 0; j < n + 1; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < d; j++) {
                s = br.readLine().split(" ");
                int end = Integer.parseInt(s[0]);
                int start = Integer.parseInt(s[1]);
                int cost = Integer.parseInt(s[2]);
                graph[start].add(new Node(end, cost));
            }

            visited = new boolean[n+1];
            dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            int[] dijkstra = dijkstra(graph, c);
            bw.write(dijkstra[0] + " " + dijkstra[1]+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int[] dijkstra(ArrayList<Node>[] graph, int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.add(new Node(start, 0));
        dist[start] = 0;
        int lastNode = 0;
        int count = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int n = node.end;
            if(visited[n])
                continue;
            visited[n] = true;
            count++;
            lastNode = n;
            for(Node next : graph[n]) {
                if(!visited[next.end] && dist[next.end] > dist[n] + next.cost) {
                    dist[next.end] = dist[n] + next.cost;
                    queue.add(new Node(next.end, dist[next.end]));
                }
            }
        }
        return new int[]{count, dist[lastNode]};
    }
}