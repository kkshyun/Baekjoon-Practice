import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N; i++) {
            if(cal(i) == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
    public static int cal(int i) {
        int sum = i;
        while(i != 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}