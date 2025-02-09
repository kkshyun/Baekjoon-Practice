import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 1 : 중요도, 0 : 순서
            Queue<int[]> queue = new LinkedList<>();
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1,o2)->Integer.compare(o2,o1));
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                queue.add(new int[]{j,Integer.parseInt(s[j])});
                priorityQueue.add(Integer.parseInt(s[j]));
            }
            int count = 0;
            int find = 0;
            while(!priorityQueue.isEmpty()) {
                Integer poll = priorityQueue.poll();
                while(!queue.isEmpty()) {
                    int[] poll1 = queue.poll();
                    if(poll != poll1[1]) {
                        queue.add(poll1);
                        continue;
                    }
                    count++;
                    if(poll1[0] == M) {
                        bw.write(count+"\n");
                        find = 1;
                    }
                    break;
                }
                if(find==1)
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}