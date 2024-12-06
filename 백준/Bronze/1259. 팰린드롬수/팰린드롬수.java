import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int i = Integer.parseInt(br.readLine());
            if(i==0)
                break;
            int[] arr = new int[5];
            int bit = 0;
            while(i>0) {
                arr[bit]=i%10;
                i/=10;
                bit++;
            }
            int check = 0;
            for (int j = 0; j < bit / 2; j++) {
                if(arr[j]!=arr[bit-1-j]) {
                    bw.write("no\n");
                    check = 1;
                    break;
                }
            }
            if(check==0)
                bw.write("yes\n");

        }
        bw.flush();
    }
}