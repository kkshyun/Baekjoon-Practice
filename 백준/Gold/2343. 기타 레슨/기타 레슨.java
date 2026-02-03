import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        System.out.println(upperBound(max, sum+1));
    }
    static int upperBound(int start, int end) {
        while(start < end) {
            int mid = start + (end - start)/2;
            int count = 1;
            int temp = 0;
            for (int i = 0; i < arr.length; i++) {
                temp += arr[i];
                if(temp > mid) {
                    count++;
                    temp = arr[i];
                }
            }
            if(count > M) // 카운트가 많이 되면 블루레이 길이를 늘려야함
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}