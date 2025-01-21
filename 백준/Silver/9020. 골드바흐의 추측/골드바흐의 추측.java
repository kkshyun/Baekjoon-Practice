import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean[] arr = new boolean[num+1];
            Arrays.fill(arr,true);
            arr[0] = false;
            arr[1] = false;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if(!arr[j])
                    continue;
                for (int k = j*2; k < arr.length; k+=j) {
                    arr[k] = false;
                }
            }

            for (int j = num/2; j >= 0; j--) {
                if(arr[j]) {
                    int temp = num - j;
                    if(arr[temp]) {
                        bw.write(j+" "+temp+"\n");
                        break;
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}