import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] arr;
    static int U, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int F = Integer.parseInt(s[0]);
        int S = Integer.parseInt(s[1]);
        int G = Integer.parseInt(s[2]);
        U = Integer.parseInt(s[3]);
        D = Integer.parseInt(s[4]);

        arr = new int[F+1];
        System.out.println(bfs(S, G));
    }

    public static String bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start,0});
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int stair = poll[0];
            if(arr[stair]==1)
                continue;
            arr[stair] = 1;
            if(stair == end)
                return String.valueOf(poll[1]);
            if(stair+U<arr.length && arr[stair+U]==0)
                queue.add(new int[]{stair+U,poll[1]+1});
            if(stair-D>0 && arr[stair-D]==0)
                queue.add(new int[]{stair-D,poll[1]+1});
        }
        return "use the stairs";
    }
}