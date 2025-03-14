import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] arr = new int[N+1];
        s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i+1] = Integer.parseInt(s[i]);
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        long count = 0;
        for (int i = 1; i < arr.length; i++) {
            prefixSum += arr[i];
            if(map.containsKey(prefixSum - K)) {
                count += map.get(prefixSum - K);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}
