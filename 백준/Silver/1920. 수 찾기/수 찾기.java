import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(0, N-1)).append("\n");
        }
        System.out.println(sb);
    }

    static int binarySearch(int start, int end) {
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(arr[mid] < target)
                start = mid + 1;
            else if(arr[mid] > target)
                end = mid - 1;
            else
                return 1;
        }
        return 0;
    }
}