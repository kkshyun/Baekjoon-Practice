import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 0; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }
        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        Arrays.fill(visited,false);
        bfs(V);
        System.out.println(sb);
    }
    static void dfs(int start) {
        if(visited[start])
            return;
        visited[start] = true;
        sb.append(start).append(" ");
        for(int next : graph[start]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
    static void bfs(int start) {
        visited[start] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(" ");
            for(int next : graph[poll]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}