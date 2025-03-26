import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1[0],o2[0]));
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            queue.add(new int[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])});
        }
        PriorityQueue<int[]> queue2 = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
        int count = 0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int start = poll[0];
            int end = poll[1];
            boolean check = false;
            int size = queue2.size();
            for (int i = 0; i < size; i++) {
                int[] poll1 = queue2.poll();
                if(poll1[1]<=start) {
                    check = true;
                    queue2.add(new int[]{start,end});
                    break;
                } else {
                    queue2.add(new int[]{poll1[0],poll1[1]});
                }
                if(poll1[1]>start)
                    break;
            }
            if(check)
                continue;
            count++;
            queue2.add(new int[]{start,end});
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}