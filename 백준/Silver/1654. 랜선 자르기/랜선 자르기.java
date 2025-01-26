import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int K = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        arr = new int[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,arr[i]);
        }
        binarySearch(N, 1, max);
        System.out.println(result);
    }

    public static void binarySearch(int key, long low, long high) {
        result = 0;
        while(low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i] / mid;
            }
            if(sum >= key) {
                if(result <= mid)
                    result = mid;
                low = mid + 1;
            } else if(sum < key)
                high = mid - 1;
        }
    }
}