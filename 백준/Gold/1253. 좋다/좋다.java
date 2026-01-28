import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int startIndex = 0;
            int endIndex = N - 1;
            long target = arr[i];
            while(startIndex < endIndex) {
                if(startIndex == i) {
                    startIndex++;
                    continue;
                }
                if(endIndex == i) {
                    endIndex--;
                    continue;
                }
                if(arr[startIndex]+arr[endIndex] > target) {
                    endIndex--;
                } else if(arr[startIndex]+arr[endIndex] < target) {
                    startIndex++;
                } else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}