import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 오른쪽
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 왼쪽
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(Integer.parseInt(br.readLine()));
        bw.write(maxHeap.peek()+"\n");
        
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > maxHeap.peek())
                minHeap.add(num);
            else
                maxHeap.add(num);

            if(maxHeap.size() <= minHeap.size()-1) {
                Integer poll = minHeap.poll();
                maxHeap.add(poll);
            } else if(maxHeap.size() > minHeap.size() + 1){
                Integer poll = maxHeap.poll();
                minHeap.add(poll);
            }
            bw.write(maxHeap.peek()+"\n");
        }
        bw.flush();
        bw.close();
    }
}