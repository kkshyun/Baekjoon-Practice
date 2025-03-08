import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int[] seq;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int level;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int R = Integer.parseInt(s[2]);
        graph = new List[N+1];
        visited = new boolean[N+1];
        seq = new int[N+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int n1 = Integer.parseInt(s[0]);
            int n2 = Integer.parseInt(s[1]);
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        for (int i = 0; i < N; i++) {
            Collections.sort(graph[i]);
        }
        level = 1;
        dfs(R);
        for (int i = 1; i < seq.length; i++) {
            bw.write(seq[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int node) {
        visited[node] = true;
        seq[node] = level++;
        for(Integer next : graph[node]) {
            if(visited[next] == false)
                dfs(next);
        }
    }
}