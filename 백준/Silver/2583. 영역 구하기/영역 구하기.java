import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int N, M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        graph = new int[M][N];
        int[] arr = new int[4];
        for(int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 4; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = arr[0] ; j < arr[2] ; j++) {
                for (int k = arr[1] ; k < arr[3]; k++) {
                    graph[k][j] = 1;
                }
            }
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < M ; i++) {
            for (int j = 0; j < N ; j++) {
                if(graph[i][j] == 0) {
                    count++;
                    list.add(bfs(i,j));
                }
            }
        }
        Collections.sort(list);
        sb.append(count).append("\n");
        for(int num : list) {
            sb.append(num).append(" ");
        }
        System.out.print(sb);
    }
    
    public static int bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        graph[x][y] = 1;
        int count = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            count++;
            for(int i = 0 ; i < 4 ; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if(graph[nx][ny] == 1)
                        continue;
                    graph[nx][ny] = 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return count;
    }
}