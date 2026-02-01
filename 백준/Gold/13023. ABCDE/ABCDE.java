import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean check = false;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            dfs(i,1);
            if(check) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }
    static void dfs(int start, int depth) {
        if(depth == 5) {
            check = true;
            return;
        }
        visited[start] = true;
        for(int next : graph[start]) {
            if(!visited[next])
                dfs(next, depth+1);
        }
        visited[start] = false;
    }
}