import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int end;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        end = Integer.parseInt(s[1]);
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int parent = Integer.parseInt(s[0]);
            int child = Integer.parseInt(s[1]);
            graph[parent].add(child);
            graph[child].add(parent);
        }
        bw.write(bfs(start)+"\n");
        bw.flush();
        bw.close();

    }
    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start,0});
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(poll[0]==end)
                return poll[1];
            if(visited[poll[0]])
                continue;
            visited[poll[0]] = true;
            for(Integer node : graph[poll[0]]) {
                if(!visited[node])
                    queue.add(new int[]{node,poll[1]+1});
            }
        }
        return -1;
    }
}