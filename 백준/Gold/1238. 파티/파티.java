import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static int[] visited, result, dist;
    static PriorityQueue<Node> queue;

    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);

        graph = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new int[N+1];
        dist = new int[N+1];
        result = new int[N+1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dist,max);

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int time = Integer.parseInt(s[2]);
            graph[start].add(new Node(end,time));
        }

        queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));

        dijkstra1(X);

        for (int i = 1; i < N+1 ; i++) {
            if(i==X)
                continue;
            queue.clear();
            Arrays.fill(visited,0);
            Arrays.fill(dist,max);
            dijkstra2(i);
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, result[i]);
        }
        System.out.println(maxTime);

    }
    public static void dijkstra1(int start) {
        // X에서 각 마을까지의 최단거리 계산
        dist[start] = 0;
        queue.add(new Node(start,0));
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            if(visited[poll.index]==1)
                continue;
            visited[poll.index]=1;
            result[poll.index] = poll.cost;
            for(Node nearVillage : graph[poll.index]) {
                if(dist[nearVillage.index]>dist[poll.index]+ nearVillage.cost) {
                    dist[nearVillage.index] = dist[poll.index]+ nearVillage.cost;
                    queue.add(new Node(nearVillage.index, dist[nearVillage.index]));
                }
            }
        }
    }
    public static void dijkstra2(int start) {
        dist[start] = 0;
        queue.add(new Node(start,0));
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            if(poll.index==X) {
                result[start] += poll.cost;
                return;
            }
            if(visited[poll.index]==1)
                continue;
            visited[poll.index]=1;
            for(Node nearVillage : graph[poll.index]) {
                if(dist[nearVillage.index]>dist[poll.index]+ nearVillage.cost) {
                    dist[nearVillage.index] = dist[poll.index]+ nearVillage.cost;
                    queue.add(new Node(nearVillage.index, dist[nearVillage.index]));
                }
            }
        }
    }
}