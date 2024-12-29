import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N,M;
    static int max = 0;
    static int[] visited, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        arr = new int[N];
        visited = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < N; i++) {
            visited = new int[N];
            if(arr[i]<=M)
                dfs(i,0,0);
        }
        System.out.println(max);

    }
    public static void dfs(int index, int result ,int depth) {
        result += arr[index];
        visited[index] = 1;
        depth++;
        if(depth==3) {
            if(max<result)
                max = result;
            visited[index] = 0;
            return;
        }
        for (int i = 1; i < N; i++) {
            if(visited[i]!=1&&(result+arr[i])<=M) {
                dfs(i,result,depth);
            }
        }
        visited[index] = 0;
    }
}