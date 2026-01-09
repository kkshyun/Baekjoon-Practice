import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N, M;
    static long[][] colors;
    static int count ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        colors = new long[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M * 3; j++) {
                colors[i][j/3] += Integer.parseInt(s[j]);
            }
            for (int j = 0; j < M; j++) {
                colors[i][j] /= 3;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int threshold = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(colors[i][j] >= threshold) {
                    colors[i][j] = 255;
                    queue.add(new int[]{i,j});
                }
                else
                    colors[i][j] = 0;
            }
        }

        count = 0;
        for(int[] cur : queue) {
            if(!visited[cur[0]][cur[1]]) {
                count++;
                bfs(cur[0], cur[1]);
            }
        }
        System.out.println(count);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(visited[poll[0]][poll[1]])
                continue;
            visited[poll[0]][poll[1]] = true;
            for (int i = 0; i < 4; i++) {
                int moveX = poll[0] + dx[i];
                int moveY = poll[1] + dy[i];
                if(moveX >= 0 && moveX <N && moveY >= 0 && moveY < M) {
                    if(!visited[moveX][moveY] && colors[moveX][moveY] == 255) {
                        queue.add(new int[]{moveX,moveY});
                    }
                }
            }
        }
    }
}