import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        long[][] graph = new long[N+1][N+1];
        long max = 10000000000L;
        arr = new int[N+1][N+1];

        for (int i = 0; i < N+1; i++) {
            Arrays.fill(graph[i],max);
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            graph[start][end] = Math.min(graph[start][end],cost);
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                for (int k = 1; k < N+1; k++) {
                    if(graph[j][i]==max||graph[i][k]==max)
                        continue;
                    if(graph[j][k]>graph[j][i]+graph[i][k]) {
                        graph[j][k]=graph[j][i]+graph[i][k];
                        arr[j][k]=i;
                    }
                }
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(graph[i][j]==max)
                    System.out.print("0 ");
                else
                    System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(graph[i][j]==0||graph[i][j]==max)
                    System.out.println("0");
                else {
                    StringBuilder path = new StringBuilder();
                    path.append(i+" ");
                    findPath(i, j, path);
                    path.append(j);
                    System.out.println(path.toString().split(" ").length + " " + path);
                }
            }
        }
    }
    public static void findPath(int start, int end, StringBuilder path) {
        if (arr[start][end] == 0)
            return;
        findPath(start, arr[start][end], path);
        path.append(arr[start][end]+" ");
        findPath(arr[start][end], end, path);
    }
}