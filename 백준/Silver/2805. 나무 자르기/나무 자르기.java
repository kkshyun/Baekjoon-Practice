import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        // 간단하게 하는 법 알아보기
        s = br.readLine().split(" ");
        arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
            if(max < arr[i])
                max = arr[i];
        }
        binarySearch(M, 0, max);
        System.out.println(result);
    }
    public static void binarySearch(int key, int low, int high) {
        result = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]>mid)
                    sum += arr[i] - mid;
            }
            if(sum>=key) {
                if(result <= mid)
                    result = mid;
                if(sum == key)
                    return;
                low = mid + 1;
            } else if(sum<key) {
                high = mid - 1;
            }
        }
    }
}