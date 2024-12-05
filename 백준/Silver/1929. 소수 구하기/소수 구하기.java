import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        // 에라토스테네스의 체 원리 사용
        boolean[] arr = new boolean[n+1];
        for (int i = 2; i < n+1; i++) {
            arr[i] = true;
        }
        for (int i = 2; i < n+1; i++) {
            if(!arr[i])
                continue;
//            for (int j = i*2; j < n + 1; j++) {
//                if (j % i == 0)
//                    arr[j] = false;
//            }
            int j = i;
            int count = 2;
            while(j*count<n+1){
                arr[j*count] = false;
                count++;
            }
        }
        for (int i = m; i < n+1; i++) {
            if(arr[i])
                bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}