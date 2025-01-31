import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] aArr = new int[n+1];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            aArr[i] = Integer.parseInt(s[i-1]);
        }
        int m = Integer.parseInt(br.readLine());
        long[] bArr = new long[m+1];
        s = br.readLine().split(" ");
        for (int i = 1; i <= m; i++) {
            bArr[i] = Integer.parseInt(s[i-1]);
        }

        for (int i = 1; i < aArr.length; i++) {
            aArr[i] = aArr[i]+ aArr[i-1];
        }

        for (int i = 1; i < bArr.length; i++) {
            bArr[i] = bArr[i]+ bArr[i-1];
        }
        List<Long> aPrefixSum = new LinkedList<>();
        for (int i = 1; i < aArr.length; i++) {
            for (int j = 0; j < i; j++) {
                aPrefixSum.add((long) (aArr[i] - aArr[j]));
            }
        }

        List<Long>  bPrefixSum = new LinkedList<>();
        for (int i = 1; i < bArr.length; i++) {
            for (int j = 0; j < i; j++) {
                bPrefixSum.add((long) (bArr[i] - bArr[j]));
            }
        }

        long count = 0;

        Map<Long,Long> map = new HashMap<>();
        for (long num : bPrefixSum) {
            map.put(num,map.getOrDefault(num,0l)+1);
        }
        for (long value : aPrefixSum) {
            count += map.getOrDefault(T - value,0l);
        }
        System.out.println(count);
    }
}