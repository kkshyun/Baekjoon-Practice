import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);
        int sqrtB = (int) Math.sqrt(b);
        boolean[] arr = new boolean[sqrtB+1];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = true;
        }

        // 1. 소수 구하기
        for (int i = 2; i < arr.length; i++) {
            if(!arr[i])
                continue;
//            for (int j = i+i; j < arr.length; j+=i) {
//                if(j<arr.length)
//                    arr[j] = false;
//            }
            int j = i+i;
            while(j<arr.length) {
                arr[j] = false;
                j+=i;
            }
        }

        // 2. 거의 소수 구하기
        // b의 제곱근 이하만 답이 될 가능성이 있기 때문에 반복문을 이렇게 씀
        int count = 0;
        for (int i = 2; i < arr.length; i++) {
            if(arr[i]) {
//                for (long j = i*i; j <= b ; j*=i) {
//                    if(j>=a)
//                        count++;
//                }
                long j = (long)i*i;
                while(j<=b) {
                    if(j>=a)
                        count++;
                    if (j > b / i) break;
                    j*=i;
                }
            }
        }
        System.out.println(count);
    }
}