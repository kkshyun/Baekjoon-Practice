import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        boolean[] arr = new boolean[b+1];
        Arrays.fill(arr,true);
        arr[0] = false;
        arr[1] = false;

        for (int i = 2; i <= Math.sqrt(b); i++) {
            if(!arr[i])
                continue;
            for (int j = i*2; j <= b; j+=i) {
                arr[j] = false;
            }
        }
        for (int i = a; i <= b; i++) {
            if(!arr[i])
                continue;
            String string = String.valueOf(i);
            StringBuilder stringBuilder = new StringBuilder(string);
            String reverseString = stringBuilder.reverse().toString();
            if(string.equals(reverseString))
                bw.write(i+"\n");
        }
        bw.write("-1\n");
        bw.flush();
        bw.close();
    }
}