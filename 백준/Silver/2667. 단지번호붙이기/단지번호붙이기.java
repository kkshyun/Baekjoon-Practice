import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        int estate = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 1) {
                    estate++;
                    list.add(bfs(i, j));
                }
            }
        }
        Collections.sort(list);
        sb.append(estate).append("\n");
        for(int c : list) {
            sb.append(c).append("\n");
        }
        System.out.print(sb);  
    }
    
    static int bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        graph[x][y] = 0;
        int count = 1;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if(nx < N && ny < N && nx >= 0 && ny >= 0) {
                    if(graph[nx][ny] == 1) {
                        count++;
                        graph[nx][ny] = 0;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return count;
    }
}