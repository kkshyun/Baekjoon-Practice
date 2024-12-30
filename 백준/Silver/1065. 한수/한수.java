import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            check(i);
        }
        System.out.println(count);
    }
    public static void check(int i) {
        String s = String.valueOf(i);
        int[] digits = new int[s.length()];
        int digit = 0;
        while(i>0) {
            digits[digit] = i%10;
            i /= 10;
            digit++;
        }
        if(digits.length>2) {
            int diff = digits[0]-digits[1];
            for (int j = 1; j < digits.length-1; j++) {
                if(diff != digits[j]-digits[j+1])
                    return;
            }
        }
        count++;
    }
}