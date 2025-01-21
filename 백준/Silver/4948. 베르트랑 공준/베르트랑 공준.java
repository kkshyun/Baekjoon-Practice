import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num==0) break;
            boolean[] arr = new boolean[2*num+1];
            Arrays.fill(arr,true);
            arr[0] = false;
            arr[1] = false;
            for (int i = 2; i <= Math.sqrt(2*num); i++) {
                if(!arr[i])
                    continue;
                for (int j = i*2; j < arr.length; j+=i) {
                    arr[j] = false;
                }
            }
            int count = 0;
            for (int i = num+1; i <= 2*num; i++) {
                if(arr[i])
                    count++;
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
    }
}