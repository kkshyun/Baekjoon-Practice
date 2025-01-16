import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Edge{
        int startNode;
        int endNode;
        long cost;

        public Edge(int startNode, int endNode, long cost) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.cost = cost;
        }
    }

    static int[] visited;
    static ArrayList<Edge> graph;
    static int endCity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int startCity = Integer.parseInt(s[1]);
        endCity = Integer.parseInt(s[2]);
        int M = Integer.parseInt(s[3]);
        graph = new ArrayList<>();
        long[] visitGraphCost = new long[N];
        long[] dist = new long[N];
        Arrays.fill(dist, Long.MIN_VALUE);

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            long cost = Long.parseLong(s[2]);
            graph.add(new Edge(start,end,-1*cost));
        }

        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            visitGraphCost[i] = Long.parseLong(s[i]);
        }
        for(Edge edge : graph) {
            edge.cost = edge.cost + visitGraphCost[edge.endNode];
        }

        dist[startCity] = visitGraphCost[startCity];
        int[] cycleArr = new int[N];
        for (int i = 0; i < N-1; i++) {
            for (Edge edge : graph) {
                if(dist[edge.startNode]==Long.MIN_VALUE)
                    continue;
                if(dist[edge.endNode] < dist[edge.startNode]+edge.cost) {
                    dist[edge.endNode] = dist[edge.startNode]+edge.cost;
                }
            }
        }

        if(dist[endCity]==Long.MIN_VALUE) {
            System.out.println("gg");
            return;
        }

        for (Edge edge : graph) {
            if(dist[edge.startNode]==Long.MIN_VALUE)
                continue;
            if(dist[edge.endNode] < dist[edge.startNode]+edge.cost) {
                cycleArr[edge.endNode] = 1;
            }
        }

        for (int i = 0; i < cycleArr.length; i++) {
            if(cycleArr[i]==1) {
                visited = new int[N];
                int bfs = bfs(i);
                if(bfs == 1) {
                    System.out.println("Gee");
                    return;
                }
            }
        }

        System.out.println(dist[endCity]);
    }

    public static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            if(poll == endCity) {
                return 1;
            }
            visited[poll] = 1;
            for(Edge edge : graph) {
                if(edge.startNode == poll && visited[edge.endNode]==0) {
                    queue.add(edge.endNode);
                }
            }
        }
        return 0;
    }
}