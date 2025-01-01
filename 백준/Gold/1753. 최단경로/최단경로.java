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
        String[] s = br.readLine().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        int K = Integer.parseInt(br.readLine());
        int[] visited = new int[V+1];
        int[] dist = new int[V+1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dist,max);

        ArrayList<Node>[] graph = new ArrayList[V+1];
        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));
        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int startIndex = Integer.parseInt(s[0]);
            int endIndex = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            graph[startIndex].add(new Node(endIndex,weight));
        }

        // 시작 정점 최단거리 처리
        dist[K] = 0;
        queue.add(new Node(K,0));

        // queue 가 비기 전까지 반복문
        while(!queue.isEmpty()) {
            // queue에서 poll 된 노드에 있는 index는 가질 수 있는 경로 중 최단경로임
            Node poll = queue.poll();

            // 이미 방문한 적 있는 경우 넘어가기
            // 왜냐하면 이미 최단경로인걸 방문했기 때문에 또 할 필요 없음
            if(visited[poll.index]==1)
                continue;

            visited[poll.index]=1;

            // 주변 노드 탐색 및 최단경로 갱신
            for(Node aroundNode : graph[poll.index]) {
                if(dist[aroundNode.index]>dist[poll.index]+ aroundNode.cost) {
                    dist[aroundNode.index] = dist[poll.index]+ aroundNode.cost;
                    queue.add(new Node(aroundNode.index,dist[aroundNode.index]));
                }
            }
        }

        // 출력
        for (int i = 1; i < V+1; i++) {
            if(dist[i]==max)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }
}