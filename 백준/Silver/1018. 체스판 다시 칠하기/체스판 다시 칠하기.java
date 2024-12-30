import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited, arr, temp;
    static int count = 0;
    static int N,M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new boolean[N][M];
        visited = new boolean[N][M];
        temp = new boolean[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if(s[j].equals("W"))
                    arr[i][j]=false;
                else
                    arr[i][j]=true;
            }
        }
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                bfs(i,j,1);
                bfs(i,j,2);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }
    public static void bfs(int startCol, int startRow, int caseNum) throws IOException {
        boolean[][] array = new boolean[8][8];
        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                array[k][l] = arr[startCol+k][startRow+l];
            }
        }
        if(caseNum==1)
            count = 0;
        else {
            count = 1;
            array[0][0] = !array[0][0];
        }
        visited = new boolean[8][8];
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            boolean color = array[poll[0]][poll[1]];
            for (int i = 0; i < 4; i++) {
                int moveCol = poll[0] + dy[i];
                int moveRow = poll[1] + dx[i];
                if(moveCol>=0&&moveRow>=0&&moveCol<8&&moveRow<8&&!visited[moveCol][moveRow]) {
                    if(array[moveCol][moveRow]==color){
                        array[moveCol][moveRow] = !color;
                        count++;
                    }
                    visited[moveCol][moveRow]= true;
                    queue.add(new int[]{moveCol,moveRow});
                }
            }
        }
        list.add(count);
    }
}