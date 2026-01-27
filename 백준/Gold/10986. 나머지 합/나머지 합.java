import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] S = new int[N+1];
        st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            S[i] = (S[i-1] + Integer.parseInt(st.nextToken()))%M;
            map.put(S[i], map.getOrDefault(S[i],0)+1);
        }
        long result = 0;
        result += map.getOrDefault(0,0);
        for(Integer key : map.keySet()) {
            result += (long) map.get(key) *(map.get(key)-1)/2;
        }
        System.out.println(result);
    }
}