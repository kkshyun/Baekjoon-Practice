import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0 ; i < N+1 ; i++) {
            graph[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        System.out.print(count);
    }

    static void dfs(int start) {
        visited[start] = true;
        for (int next : graph[start]) {
            if(!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}