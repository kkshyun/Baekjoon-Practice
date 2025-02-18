import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[100][100];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            for (int j = y; j < y+10; j++) {
                for (int k = x; k < x+10; k++) {
                    arr[j][k] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == true)
                    count++;
            }
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}