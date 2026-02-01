import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int start) {
        if(visited[start])
            return;
        visited[start] = true;
        for(int next : graph[start]) {
            if(!visited[next])
                dfs(next);
        }
    }
}