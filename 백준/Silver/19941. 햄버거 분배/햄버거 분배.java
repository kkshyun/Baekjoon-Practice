import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split("");
        int count = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i].equals("P")) {
                startIndex = Math.max(i - K, 0);
                endIndex = Math.min(i + K, N - 1);
                for (int j = startIndex; j <= endIndex; j++) {
                    if(arr[j].equals("H")) {
                        count++;
                        arr[j] = "N";
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}