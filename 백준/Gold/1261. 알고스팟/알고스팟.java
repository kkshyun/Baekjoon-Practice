import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> results;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int M, N;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
        results = new LinkedList<>();
        dijkstra();
        Collections.sort(results);
        System.out.println(results.get(0));
    }

    public static void dijkstra() {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2],o2[2]));
        queue.add(new int[]{0,0,0});
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(graph[poll[0]][poll[1]]==2)
                continue;
            graph[poll[0]][poll[1]]=2;
            if(poll[0]==N-1&&poll[1]==M-1)
                results.add(poll[2]);
            for (int i = 0; i < 4; i++) {
                int moveCol = poll[0] + dy[i];
                int moveRow = poll[1] + dx[i];
                if(moveCol<N&&moveRow<M&&moveCol>=0&&moveRow>=0) {
                    if(graph[moveCol][moveRow]==2)
                        continue;
                    if(graph[moveCol][moveRow]==1)
                        queue.add(new int[]{moveCol,moveRow,poll[2]+1});
                    else
                        queue.add(new int[]{moveCol,moveRow,poll[2]});
                }
            }

        }
    }
}