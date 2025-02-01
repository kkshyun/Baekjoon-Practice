import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        int L = Integer.parseInt(s[2]);
        arr = new int[N+2];
        arr[0] = 0;
        arr[arr.length-1] = L;
        if(N!=0) {
            s = br.readLine().split(" ");
            for (int i = 1; i < arr.length-1; i++) {
                arr[i] = Integer.parseInt(s[i-1]);
            }
            Arrays.sort(arr);
        }
        // 휴게소 구간 최댓값 구하기
        int max = 0;
        for (int i = 1; i < arr.length ; i++) {
            max = Math.max(max, arr[i]-arr[i-1]);
        }
        System.out.println(binarySearch(max));




    }
    public static int binarySearch(int high) {
        int start = 1;
        int end = high;
        while(start < end) {
            int mid = (start+end)/2;

            int startValue = 0;
            int count = 0;
            for (int i = 1; i < arr.length; i++) {
                if(startValue+mid >= arr[i]) {
                    startValue = arr[i];
                    continue;
                }
                count++;
                startValue = startValue+mid;
                i--;
            }
            if(count <= M)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}