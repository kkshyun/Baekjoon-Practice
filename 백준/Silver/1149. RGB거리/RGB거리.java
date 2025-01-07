import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] colors;
    static int[][] remember;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colors = new int[N][3];
        remember = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            colors[i][0] = Integer.parseInt(s[0]);
            colors[i][1] = Integer.parseInt(s[1]);
            colors[i][2] = Integer.parseInt(s[2]);
        }

        dp();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if(remember[N-1][i]<min)
                min = remember[N-1][i];
        }
        System.out.println(min);
    }
    public static void dp() {
        remember[0][0] = colors[0][0];
        remember[0][1] = colors[0][1];
        remember[0][2] = colors[0][2];

        for (int i = 1; i < N; i++) {
            remember[i][0] = Math.min(remember[i-1][1] + colors[i][0], remember[i-1][2] + colors[i][0]);
            remember[i][1] = Math.min(remember[i-1][0] + colors[i][1], remember[i-1][2] + colors[i][1]);
            remember[i][2] = Math.min(remember[i-1][0] + colors[i][2], remember[i-1][1] + colors[i][2]);
        }
    }
}