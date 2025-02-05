import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int num = 1;
            for (int j = 2; j <= N; j++) {
                if(num == N)
                    break;
                int count = 0;
                while(N>1) {
                    if(N % j != 0)
                        break;
                    N /= j;
                    num *= j;
                    count++;
                }
                if(count != 0)
                    bw.write(j+" "+count+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}