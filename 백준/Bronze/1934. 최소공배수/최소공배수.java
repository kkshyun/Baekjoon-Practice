import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if(b>a) {
                int temp = b;
                b = a;
                a = temp;
            }
            int m = a % b;
            while(m!=0) {
                a = b;
                b = m;
                m = a % b;
            }
            int gcb = b;
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            int result = gcb * (a/gcb) * (b/gcb);
            bw.write(result+"\n");
        }
        bw.flush();
    }
}