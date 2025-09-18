import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Test = Integer.parseInt(br.readLine());
        Queue<Integer> priorityQueue = new PriorityQueue<>((o1,o2) -> Integer.compare(o2,o1));
        Queue<int[]> queue = new LinkedList<>();
        String[] s;
        for (int i = 0; i < Test; i++) {
            priorityQueue.clear();
            queue.clear();
            s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(s[j]);
                queue.add(new int[]{j,num});
                priorityQueue.add(num);
            }
            int count = 0;
            while(!queue.isEmpty() && !priorityQueue.isEmpty()) {
                int priority = queue.peek()[1];
                if(priorityQueue.peek() > priority) {
                    queue.add(queue.poll());
                    continue;
                }
                int index = queue.poll()[0];
                count++;
                priorityQueue.poll();
                if(index == M)
                    break;
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
    }
}