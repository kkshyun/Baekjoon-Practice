import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static class Node{
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 방문, 최단거리 배열 생성
        int[] visited = new int[N+1];
        int[] dist = new int[N+1];

        int max = Integer.MAX_VALUE;
        Arrays.fill(dist,max);

        // 그래프 입력
        ArrayList<Node>[] graph = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int startCity = Integer.parseInt(s[0]);
            int endCity = Integer.parseInt(s[1]);
            int busCost = Integer.parseInt(s[2]);
            graph[startCity].add(new Node(endCity,busCost));
        }

        // 출발도시 & 도착 도시 입력
        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);

        // 우선순위 큐
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));

        // 출발도시 처리
        dist[start] = 0;
        queue.add(new Node(start,0));

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            if(poll.index==end) {
                System.out.println(poll.cost);
                break;
            }
            // 방문 처리
            if(visited[poll.index]==1)
                continue;
            visited[poll.index]=1;
            // 인접한 노드 방문
            for(Node city : graph[poll.index]) {
                if(dist[city.index] > dist[poll.index]+city.cost) {
                    dist[city.index] = dist[poll.index]+city.cost;
                    queue.add(new Node(city.index,dist[city.index]));
                }
            }
        }
    }
}