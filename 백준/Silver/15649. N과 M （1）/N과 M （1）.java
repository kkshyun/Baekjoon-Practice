import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] visited;
    static List<Integer>[] list;
    static int m;
    static int n;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if(i!=j) {
                    list[i].add(j);
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            visited = new boolean[n+1];
            DFS(1,i,temp);
        }
        bw.flush();
        bw.close();
    }
    public static void DFS(int depth, int n, List<Integer> temp) throws IOException {
        if(visited[n])
            return;
        temp.add(n);
        visited[n]=true;
        if(depth==m) {
            for (int i: temp) {
                bw.write(i+" ");
            }
            bw.write("\n");
        } else {
            for(int node: list[n]) {
                if(!visited[node]) {
                    DFS(depth+1,node,temp);
                }
            }
        }
        temp.remove(temp.size() - 1);
        visited[n]=false;
    }
}