import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static char[][] graph;
    static int N, M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        int startX = 0;
        int startY = 0;
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < str.length(); j++) {
                graph[i][j] = str.charAt(j);
                if(str.charAt(j) == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }
        int count = bfs(startX,startY);
        if(count == 0)
            System.out.print("TT");
        else
            System.out.print(count);
    }
    public static int bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        graph[x][y] = 'Y';
        int count = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(graph[nx][ny] == 'X' || graph[nx][ny] == 'Y')
                        continue;
                    if(graph[nx][ny] == 'P') {
                        count++;
                    }
                    graph[nx][ny] = 'Y';
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return count;
    }
}