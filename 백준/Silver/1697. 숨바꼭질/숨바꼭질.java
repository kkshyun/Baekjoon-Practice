import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, K;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int max = Math.max(N,K) * 2;
        visited = new boolean[max+1]; // 방문했는지
        System.out.print(bfs());
    }
    
    static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{N,0});
        visited[N] = true;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            if(curr[0] == K)
                return curr[1];
            int next = curr[0]+1;
            if(next < visited.length && !visited[next]) {
                queue.add(new int[]{next, curr[1]+1});
                visited[next] = true;
            }
            next = curr[0]-1;
            if(next >= 0 && !visited[next]) {
                queue.add(new int[]{next, curr[1]+1});
                visited[next] = true;
            }
            next = curr[0]*2;
            if(next < visited.length && !visited[next]) {
                queue.add(new int[]{next, curr[1]+1});
                visited[next] = true;
            }
        }
        return -1;
    }
}