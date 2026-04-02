import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 0 ; i < N+1 ; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        int count = 0;
        for(int i = 1 ; i < N+1 ; i++) {
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.print(count);
    }

    public static void dfs(int n) {
        visited[n] = true;
        for(int next : graph[n]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}