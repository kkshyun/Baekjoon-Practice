import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrN = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(br.readLine());
            pq.add(arrN[i]);
        }
        int count = 0;
        while(pq.size()>1) {
            int pollNum1 = pq.poll();
            int pollNum2 = pq.poll();
            int sum = pollNum1+pollNum2;
            count += sum;
            pq.add(sum);
        }

        System.out.println(count);
    }
}
