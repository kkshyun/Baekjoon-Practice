import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[9][9];
        int max = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < 9; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(arr[j]);

                if(board[i][j] > max) {
                    max = board[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(max);
        System.out.println((row+1) + " " + (col+1));
    }
}
