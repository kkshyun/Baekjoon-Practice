import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
        System.out.println(sb);
    }

    static void dfs(int num, int len) {
        if(len == N) {
            sb.append(num).append("\n");
            return;
        }

        int[] cand = {1,3,5,7,9};
        for(int c : cand) {
            int next = num*10 + c;
            if(isPrime(next)) {
                dfs(next, len+1);
            }
        }
    }

    static boolean isPrime(int num) {
        if(num < 2)
            return false;
        if(num % 2 == 0)
            return num == 2;
        for (int i = 3; (long)i * i <= num; i += 2) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}