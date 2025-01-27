import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] dist = new int[N+1][N+1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int node1 = Integer.parseInt(s[0]);
            int node2 = Integer.parseInt(s[1]);
            dist[node1][node2] = 1;
            dist[node2][node1] = 1;
        }

        for (int mid = 1; mid < N+1; mid++) {
            for (int start = 1; start < N+1; start++) {
                for (int end = 1; end < N+1; end++) {
                    if(dist[start][mid]!=Integer.MAX_VALUE && dist[mid][end]!=Integer.MAX_VALUE) {
                        if(dist[start][end]>dist[start][mid]+dist[mid][end])
                            dist[start][end]=dist[start][mid]+dist[mid][end];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i < N+1; i++) {
            int temp = 0;
            for (int j = 1; j < N+1; j++) {
                temp += dist[i][j];
            }
            if(min>temp) {
                min = temp;
                result = i;
            }
        }
        System.out.println(result);
    }
}