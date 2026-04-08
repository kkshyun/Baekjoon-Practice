import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++) {
                graph[i][j] = str.charAt(j);
            }
        }
        int count = 0;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(!visited[i][j]) {
                    count++;
                    bfs(i,j,graph[i][j]);
                }
            }
        }
        System.out.print(count+" ");
        count = 0;
        
        for(int i = 0 ; i < N ; i++) {
            Arrays.fill(visited[i], false);
        }
        
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(!visited[i][j]) {
                    count++;
                    bfsColorBlind(i,j,graph[i][j]);
                }
            }
        }
        System.out.print(count);  
    }

    static void bfs(int x, int y, char color) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if(!visited[nx][ny] && graph[nx][ny] == color) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    static void bfsColorBlind(int x, int y, char color) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y});
        if(color == 'R' || color == 'G') {
            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                for(int i = 0 ; i < 4 ; i++) {
                    int nx = curr[0] + dx[i];
                    int ny = curr[1] + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if(!visited[nx][ny] && (graph[nx][ny] == 'R' || graph[nx][ny] == 'G')) {
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        } else {
            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                for(int i = 0 ; i < 4 ; i++) {
                    int nx = curr[0] + dx[i];
                    int ny = curr[1] + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if(!visited[nx][ny] && graph[nx][ny] == color) {
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }  
}