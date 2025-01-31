import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
            if(arr[i]>max)
                max = arr[i];
        }
        int M = Integer.parseInt(br.readLine());

        int start = 0;
        int end = max;
        int sum = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += Math.min(arr[i],mid);
            }
            if(sum == M){
                System.out.println(mid);
                return;
            } else if(sum < M)
                start = mid +1;
            else
                end = mid -1;
        }

        System.out.println(end);

    }
}