import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
                if(o1[0]==o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
        });
        StringTokenizer st;
        for (int i = 0; i < N ;i++ ) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new int[]{x, y});
        }
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            sb.append(temp[0]).append(" ").append(temp[1]).append("\n");
        }
        System.out.print(sb);
    }
}