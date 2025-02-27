import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[2][2];
        for (int i = 0; i < 2; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        int under = arr[0][1] * arr[1][1];
        int top = arr[0][0]*arr[1][1] + arr[1][0]*arr[0][1];
        int tempUnder = under;
        int tempTop = top;
        for (int i = 2; i <= Integer.max(tempTop,tempUnder); i++) {
            while(top % i == 0 && under % i==0) {
                under = under / i;
                top = top / i;
            }
        }
        bw.write(top +" "+under+"\n");
        bw.flush();
        bw.close();
    }
}
