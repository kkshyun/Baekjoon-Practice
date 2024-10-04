import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int node = Integer.parseInt(str[0]);
        int edge = Integer.parseInt(str[1]);
        A = new ArrayList[node];
        visited = new boolean[node];
        for (int i = 0; i < node; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edge; i++) {
            str = br.readLine().split(" ");
            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 0; i < node; i++) {
            DFS(1,i);
            if(result) break;
        }
        if(result)System.out.println("1");
        else System.out.println("0");
    }

    static void DFS(int depth, int n) {
        if (result||depth==5) {
            result = true;
            return;
        }
        visited[n] = true;
        for (int node : A[n]) {
            if (!visited[node])
                DFS(depth+1, node);
        }
        visited[n] = false;
    }
}
