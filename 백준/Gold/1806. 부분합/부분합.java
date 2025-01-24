import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int S = Integer.parseInt(s[1]);
        int[] arr = new int[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int startIndex = 0;
        int endIndex = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(true) {
            if(sum >= S) {
                sum -= arr[startIndex++];
            }
            else if(endIndex == N)
                break;
            else if(sum < S) {
                sum += arr[endIndex++];
            }

            if(sum >= S && min > endIndex - startIndex)
                min = endIndex - startIndex;
        }
        if(min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);
    }
}