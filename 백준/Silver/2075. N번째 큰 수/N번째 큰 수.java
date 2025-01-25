import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o2[0],o1[0]));

        for (int i = 0; i < N; i++) {
            queue.add(new int[]{arr[N-1][i],N-1,i});
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            count++;
            if(count == N) {
                System.out.println(poll[0]);
                return;
            }
            if(poll[1]-1>=0)
                queue.add(new int[]{arr[poll[1]-1][poll[2]],poll[1]-1,poll[2]});
        }
    }
}