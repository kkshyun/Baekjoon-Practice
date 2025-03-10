import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        List<Integer>[] list = new List[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            list[i].add(arr[i]);
            int lastCheck = -1;
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i] && dp[i]<dp[j]+1) {
                    dp[i] = dp[j]+1;
                    lastCheck = j;
                }
            }
            if(lastCheck==-1)
                continue;
            for (int j = 0; j < list[lastCheck].size(); j++) {
                list[i].add(list[lastCheck].get(j));
            }
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if(max<dp[i]) {
                max = dp[i];
                index = i;
            }
        }
        Collections.sort(list[index]);
        bw.write(max+"\n");
        for (int i = 0; i < list[index].size(); i++) {
            bw.write(list[index].get(i)+" ");
        }
        bw.flush();
        bw.close();
    }
}
