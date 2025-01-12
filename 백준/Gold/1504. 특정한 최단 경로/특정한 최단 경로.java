import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Node {
        int end;
        long cost;

        public Node(int end, long cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static int[] visited;
    static long[] dist;
    static List<Node>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        visited = new int[N+1];
        dist = new long[N+1];
        Arrays.fill(dist,1000000000l);
        nodes = new List[N+1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            nodes[start].add(new Node(end, cost));
            nodes[end].add(new Node(start, cost));
        }

        s = br.readLine().split(" ");
        int[] mustVisitNode = new int[2];
        mustVisitNode[0] = Integer.parseInt(s[0]);
        mustVisitNode[1] = Integer.parseInt(s[1]);

        long distMustVisitNode0 = dijkstra(1, mustVisitNode[0]);

        visited = new int[N+1];
        dist = new long[N+1];
        Arrays.fill(dist,1000000000l);

        long distMustVisitNode1 = dijkstra(1, mustVisitNode[1]);


        int result = 0;
        int result1 = 0;
        long temp = 0;
        if(distMustVisitNode0!=-1) {
            result += distMustVisitNode0;
            visited = new int[N+1];
            dist = new long[N+1];
            Arrays.fill(dist,1000000000l);
            temp = dijkstra(mustVisitNode[0], mustVisitNode[1]);
            if(temp == -1) {
                System.out.println("-1");
                return;
            }
            result += temp;
            visited = new int[N+1];
            dist = new long[N+1];
            Arrays.fill(dist,1000000000l);
            temp = dijkstra(mustVisitNode[1],N);
            if(temp == -1) {
                System.out.println("-1");
                return;
            }
            result += temp;
        }else {
            System.out.println("-1");
            return;
        }

        if(distMustVisitNode1!=-1) {
            result1 += distMustVisitNode1;
            visited = new int[N+1];
            dist = new long[N+1];
            Arrays.fill(dist,1000000000l);
            temp = dijkstra(mustVisitNode[1], mustVisitNode[0]);
            if(temp == -1) {
                System.out.println("-1");
                return;
            }
            result1 += temp;
            visited = new int[N+1];
            dist = new long[N+1];
            Arrays.fill(dist,1000000000l);
            temp = dijkstra(mustVisitNode[0],N);
            if(temp == -1) {
                System.out.println("-1");
                return;
            }
            result1 += temp;
        }
        else {
            System.out.println("-1");
            return;
        }
        if(result<result1)
            System.out.println(result);
        else
            System.out.println(result1);



    }
    public static long dijkstra(int startNode, int endNode) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->Long.compare(o1.cost, o2.cost));
        queue.add(new Node(startNode,0));
        dist[startNode] = 0;
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            if(visited[poll.end]==1)
                continue;
            if(poll.end == endNode)
                return dist[endNode];
            visited[poll.end]=1;
            for(Node aroundNode : nodes[poll.end]) {
                if(dist[aroundNode.end]>dist[poll.end]+aroundNode.cost) {
                    dist[aroundNode.end]=dist[poll.end]+aroundNode.cost;
                    queue.add(new Node(aroundNode.end, dist[aroundNode.end]));
                }
            }
        }
        return -1;
    }
}