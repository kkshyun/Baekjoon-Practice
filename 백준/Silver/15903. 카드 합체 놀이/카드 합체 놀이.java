import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        PriorityQueue<Long> queue = new PriorityQueue<>((o1,o2)->Long.compare(o1,o2));

        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(s[i]));
        }

        for (int i = 0; i < m; i++) {
            Long poll = queue.poll();
            Long poll1 = queue.poll();
            queue.add(poll+poll1);
            queue.add(poll+poll1);
        }
        long sum = 0;
        while(!queue.isEmpty()) {
            sum += queue.poll();
        }
        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}
