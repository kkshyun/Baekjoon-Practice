import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
        public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            String[] temp = br.readLine().split("");
            for(int j = 0 ; j < M ; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int max = 1;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                for(int k = 1 ; k < Math.min(N,M); k++) {
                    if(i+k >= N || j + k >= M)
                        break;
                    if(arr[i][j] == arr[i][j+k] && arr[i][j] == arr[i+k][j] && arr[i][j] == arr[i+k][j+k])
                        max = Math.max((k+1)*(k+1),max);
                }
            }
        }
        System.out.print(max);
    }
}