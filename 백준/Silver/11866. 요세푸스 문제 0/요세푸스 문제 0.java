import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while(!queue.isEmpty()) {
            if(queue.size() == 1) {
                sb.append(queue.poll());
                break;
            }
            for (int i = 0; i < K-1; i++) {
                Integer poll = queue.poll();
                queue.add(poll);
            }
            sb.append(queue.poll()+", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}