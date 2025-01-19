import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1,o2));
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0) {
                if(queue.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(queue.poll()+"\n");
            }
            else {
                queue.add(num);
            }
        }
        bw.flush();
        bw.close();
    }
}