import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> result;
    static boolean[] visited;
    static int K;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
        int X = Integer.parseInt(s[3]);
        graph = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            graph[start].add(end);
        }

        dijkstra(X);
        if(result.isEmpty())
            System.out.println(-1);
        else {
            Collections.sort(result);
            for(Integer i : result) {
                System.out.println(i);
            }
        }
    }

    public static void dijkstra(int startNode) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
        queue.add(new int[]{startNode,0});
        result = new LinkedList<>();
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(visited[poll[0]])
                continue;
            if(poll[1] == K)
                result.add(poll[0]);
            visited[poll[0]] = true;
            for(Integer i :graph[poll[0]])
                    queue.add(new int[]{i,poll[1]+1});

        }
    }
}