import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = n-1; i >= 0; i--) {
            if(arrN[i]<=k) {
                count += k / arrN[i];
                k = k % arrN[i];
            }
        }

        System.out.println(count);
    }
}
