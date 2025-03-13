import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int R,C;
    static int result;
    static Set<String> set;
    static  String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        arr = new String[R][C];

        for (int i = 0; i < R; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                arr[i][j] = s[j];
            }
        }
        result = 0;
        set = new HashSet<>();
        set.add(arr[0][0]);
        dfs(0,0,1);
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
    static void dfs(int col, int row, int depth) {
        if(result<depth)
            result = depth;
        for (int i = 0; i < 4; i++) {
            int moveCol = col + dy[i];
            int moveRow = row + dx[i];
            if(moveCol<R && moveRow<C && moveCol>=0 && moveRow>=0) {
                if(!set.contains(arr[moveCol][moveRow])) {
                    set.add(arr[moveCol][moveRow]);
                    dfs(moveCol,moveRow,depth+1);
                    set.remove(arr[moveCol][moveRow]);
                }
            }
        }
    }
}