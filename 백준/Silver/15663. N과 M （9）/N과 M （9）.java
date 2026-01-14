import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static StringBuilder sb;
    static int[] result;
    static int[] arr;
    static boolean[] visited;
    static Set<String> finalResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        result = new int[M];
        arr = new int[N];
        visited = new boolean[N];
        finalResult = new LinkedHashSet<>();
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        perm(0);
        for (String str : finalResult) {
            sb.append(str).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void perm(int r) {
        if(r == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            finalResult.add(sb.toString());
            sb.setLength(0);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i])
                continue;
            visited[i] = true;
            result[r] = arr[i];
            perm(r+1);
            visited[i] = false;
        }
    }
}