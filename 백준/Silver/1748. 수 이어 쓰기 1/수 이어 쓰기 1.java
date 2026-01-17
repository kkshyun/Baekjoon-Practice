import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int temp = N;
        int nCount = 0;
        long totalCount = 0;
        // N의 자릿수 구하기
        while(temp != 0) {
            temp /= 10;
            nCount++;
        }
        for (int i = 1; i < nCount; i++) {
            totalCount += (long) (i * 9 * Math.pow(10, i-1));
        }
        totalCount += (long) (nCount * (N - Math.pow(10, nCount-1)+ 1));
        System.out.println(totalCount);
    }
}