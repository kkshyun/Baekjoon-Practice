import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;
    static boolean DFSResult = false;
    static boolean BFSResult;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int node = Integer.parseInt(str[0]);
        int edge = Integer.parseInt(str[1]);
        int start = Integer.parseInt(str[2]);
        A = new ArrayList[node+1];
        visited = new boolean[node+1];
        for (int i = 1; i <= node; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edge; i++) {
            str = br.readLine().split(" ");
            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);
            A[s].add(e);
            A[e].add(s);
        }
        for (int i = 1; i <= node; i++) {
            A[i].sort((a, b) -> a - b);
        }
        DFS(start);
        bw.write("\n");
        visited = new boolean[node+1];
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            BFS();
        }
        bw.flush();
        bw.close();
    }

    static void DFS(int n) throws IOException {
        if(DFSResult || visited[n]) {
            DFSResult = true;
            return;
        }
        visited[n] = true;
        bw.write(n+" ");
        for(int i : A[n]) {
            if(!visited[i])
                DFS(i);
        }
    }

    static void BFS() throws IOException {
        Integer poll = queue.poll();
        bw.write(poll+" ");
        for(int i : A[poll]) {
            if(!visited[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }
    }
}
