import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[1000001];
        Arrays.fill(arr,true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i <= Math.sqrt(arr.length-1); i++) {
            if(!arr[i])
                continue;
            for (int j = i*2; j <= arr.length-1; j+=i) {
                arr[j] = false;
            }
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 2; j <= num/2; j++) {
                if(arr[j]) {
                    int remain = num - j;
                    if(arr[remain])
                        count++;
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
    }
}