import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            if(o1[0]!=o2[0])
                return o2[0]-o1[0];
            if(o1[1]!=o2[1])
                return o2[1]-o1[1];
            return o2[2]-o1[2];
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{gold,silver,bronze,country});
        }
        int order = 0;
        int count = 0;
        int goldCount = -1;
        int silverCount = -1;
        int bronzeCount = -1;
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            if(goldCount != poll[0] || silverCount != poll[1] || bronzeCount != poll[2]) {
              order = count + 1;
              goldCount = poll[0];
              silverCount = poll[1];
              bronzeCount = poll[2];
            }
            count++;
            if(poll[3] == K)
                System.out.println(order);
        }
    }
}