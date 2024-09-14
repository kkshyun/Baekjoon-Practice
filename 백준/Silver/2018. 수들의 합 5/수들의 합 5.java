import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 0;
        long count = 0;
        for (int i = 1; i <= n; i++) {
            result = 0;
            for (int j = i; j <= n ; j++) {
                if(result <= n) {
                    result += j;
                    if(result == n) {
                        count ++;
                        break;
                    }
                }else {
                    break;
                }
            }
        }
        System.out.print(count);
    }
}
