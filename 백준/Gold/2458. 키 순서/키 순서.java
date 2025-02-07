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
        int[][] graph = new int[N+1][N+1];
        int max = 10000000;
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(graph[i],max);
            graph[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int shortPerson = Integer.parseInt(s[0]);
            int longPerson = Integer.parseInt(s[1]);
            graph[shortPerson][longPerson] = 1;
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    if(graph[j][k] > graph[j][i]+graph[i][k]) {
                        graph[j][k] = graph[j][i]+graph[i][k];
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i < N+1; i++) {
            int count = 0;
            for (int j = 1; j < N+1; j++) {
                if(j == i)
                    continue;
                if(graph[j][i] != max)
                    count++;
                if(graph[i][j] != max)
                    count++;
            }
            if(count==N-1)
                result++;
        }
        System.out.println(result);
    }
}