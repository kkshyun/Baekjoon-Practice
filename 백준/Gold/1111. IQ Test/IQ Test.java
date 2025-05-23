import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        if(N==1) {
            bw.write("A\n");
            bw.flush();
            bw.close();
            return;
        }
       if(arr[0] != arr[1] && N==2) {
            bw.write("A\n");
            bw.flush();
            bw.close();
            return;
        }

        if(arr[0] == arr[1]) {
            int sameNum = arr[0];
            for(int a : arr) {
                if(a!=sameNum) {
                    bw.write("B\n");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
            bw.write(arr[0]+"\n");
            bw.flush();
            bw.close();
            return;
        }

        int a;
        int b;

        // a,b 구하기
        int numerator = arr[1] - arr[2];
        int denominator = arr[0] - arr[1];

        if(numerator % denominator == 0) {
            a = numerator / denominator;
            b = arr[1] - a*arr[0];
        } else {
            bw.write("B\n");
            bw.flush();
            bw.close();
            return;
        }

        // 마지막 전까지 a,b 맞는지 확인
        boolean check = true;
        for (int i = 2; i < N-1; i++) {
            if(b != arr[i+1] - a*arr[i]) {
                check = false;
                break;
            }
        }
        if(check == false) {
            bw.write("B\n");
            bw.flush();
            bw.close();
            return;
        }
        // 마지막 숫자를 가지고 a,b 사용해서 결과 구하기
        int result = a*arr[N-1] + b;
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}