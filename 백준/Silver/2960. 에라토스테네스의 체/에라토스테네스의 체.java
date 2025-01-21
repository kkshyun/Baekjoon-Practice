import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        boolean[] arr = new boolean[N+1];
        Arrays.fill(arr,true);
        arr[0] = false;
        arr[1] = false;
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if(!arr[i])
                continue;

            for (int j = i; j <= N; j+=i) {
                if(arr[j]) {
                    count++;
                    if(count == K) {
                        System.out.println(j);
                        return;
                    }
                    arr[j] = false;
                }
            }
        }
    }
}