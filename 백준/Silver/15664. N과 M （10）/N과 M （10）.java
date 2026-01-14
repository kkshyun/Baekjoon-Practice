import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, result;
    static Set<String> finalResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N];
        result = new int[M];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        finalResult = new LinkedHashSet<>();
        Arrays.sort(arr);
        combination(0,0);
        for(String str : finalResult){
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
    public static void combination(int start, int r) {
        if(r == M) {
            String str = "";
            for (int i = 0; i < M; i++) {
                str += result[i]+" ";
            }
            finalResult.add(str);
            return;
        }
        for (int i = start; i < N; i++) {
            result[r] = arr[i];
            combination(i+1, r+1);
        }
    }
}