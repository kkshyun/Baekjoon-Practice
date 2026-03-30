import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        
        for(int i = 0 ; i < N+1 ; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i = 0 ; i < N+1 ; i++) {
            Collections.sort(graph[i]);
        }

        dfs(start);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(start);
        System.out.print(sb);
        
    }

    static void dfs(int s) {
        sb.append(s).append(" ");
        visited[s] = true;
        for(int next : graph[s]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int s) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        visited[s] = true;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            sb.append(curr).append(" ");
            for(int next : graph[curr]) {
            if(!visited[next]) {
                visited[next] = true;
                queue.add(next);
            }
        }
        }
    }
    
}