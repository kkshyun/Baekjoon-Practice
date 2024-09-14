import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        long count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        // 합 배열 s 구하기
        long[] s = new long[n+1];
        String[] numArr = br.readLine().split(" ");
        for (int i = 1; i < s.length; i++) {
            int num = Integer.parseInt(numArr[i-1]);
            // s[i] : 입력받은 numArr 첫번째부터 i번째 까지의 합
            s[i] = s[i-1] + num;
            // s[i] : s[i]를 m으로 나눈 나머지
            s[i] = s[i] % m;
        }
//        for (int i = 0; i < s.length; i++) {
//            System.out.println(s[i]);
//        }

        // s[j] % m == 0
        // (s[j] - s[i]) % m == 0 --> s[j] % m - s[i] % m == 0 --> s[j] % m == s[i] % m
        // 나머지에 따른 개수 카운트 후 조합 계산
        long[] mCount = new long[m];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < mCount.length; j++) {
                if (s[i] == j) {
                    mCount[j] += 1;
                    break;
                }
            }
        }
//        for (int i = 0; i < mCount.length; i++) {
//            System.out.println(i+":"+mCount[i]);
//        }
        for (int i = 0; i < mCount.length; i++) {
            if(mCount[i]!=0) {
                count += cCal(mCount[i]);
            }
        }
        System.out.print(count);
    }


    // 원소 값이 같은 2개의 원소를 뽑는 모든 경우의 수: 조합
    public static long cCal(long n) {
        long numerator = 1;
        // n!/(n-r)! 계산
        // 여기서 r은 2
        for (long k = n-1; k <= n; k++) {
            numerator *= k;
        }
        // (n!/(n-r)!)/r! --> (numerator) / 2! 계산
        return numerator / 2;
    }
}
