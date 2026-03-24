import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int gold = -1;
        int silver = -1;
        int bronze = -1;
        int goldCount, silverCount, bronzeCount, order;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> {
            if(o1[0] != o2[0])
                return o2[0] - o1[0];
            else if(o1[1] != o2[1])
                return o2[1] - o1[1];
            else
                return o2[2] - o2[2];
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());
            goldCount = Integer.parseInt(st.nextToken());
            silverCount = Integer.parseInt(st.nextToken());
            bronzeCount = Integer.parseInt(st.nextToken());
            pq.add(new int[]{goldCount, silverCount, bronzeCount, order});
        }
        int count = 0;
        int rank = 0;
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            count++;
            if(gold != temp[0] || silver != temp[1] || bronze != temp[2]) {
                rank = count;
                gold = temp[0];
                silver = temp[1];
                bronze = temp[2];
            }
            if(temp[3] == K) {
                System.out.print(rank);
                return;
            }
        }
    }
}