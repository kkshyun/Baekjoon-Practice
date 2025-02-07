import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dist;
    static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        D = Integer.parseInt(s[1]);

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1[0],o2[0]));

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            queue.add(new int[]{start,end,cost});
        }

        // 가중치 -> 다익스트라
        // 여기까지 갈 수 있을 때 최소값 비교해서 우선순위큐에 넣기
        dist = new int[D+1];
        for (int i = 0; i <= D; i++) {
            dist[i] = i;
        }

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(poll[0]<=D && poll[1] <= D) {
                if(dist[poll[1]] > dist[poll[0]] + poll[2]) {
                    dist[poll[1]] = dist[poll[0]] + poll[2];
                    for (int i = poll[1]; i <= D ; i++) {
                        dist[i] = Math.min(dist[i],dist[poll[1]] + i - poll[1]);
                    }
                }
            }
        }

        System.out.println(dist[D]);
    }

}
