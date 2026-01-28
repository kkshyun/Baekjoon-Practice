import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int startIndex = 0;
        int endIndex = N-1;
        int sum = arr[startIndex] + arr[endIndex];
        int count = 0;
        while(startIndex < endIndex) {
            if(sum > M) {
                sum += -arr[endIndex--] + arr[endIndex];
            } else if(sum < M) {
                sum += -arr[startIndex++] + arr[startIndex];
            } else {
                count++;
                sum += -arr[endIndex--] -arr[startIndex++] + arr[endIndex] + arr[startIndex];
            }
        }
        System.out.println(count);
    }
}