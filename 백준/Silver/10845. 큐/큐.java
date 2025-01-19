import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque= new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            if(s[0].equals("push"))
                deque.offer(Integer.parseInt(s[1]));
            else if(s[0].equals("pop")) {
                if(deque.isEmpty())
                    bw.write(-1+"\n");
                else
                    bw.write(deque.pollFirst()+"\n");
            }
            else if(s[0].equals("front")) {
                if(deque.isEmpty())
                    bw.write(-1+"\n");
                else
                    bw.write(deque.peekFirst()+"\n");
            } else if(s[0].equals("back")) {
                if(deque.isEmpty())
                    bw.write(-1+"\n");
                else
                    bw.write(deque.peekLast()+"\n");
            } else if(s[0].equals("size"))
                bw.write(deque.size()+"\n");
            else if(s[0].equals("empty")){
                if(deque.isEmpty())
                    bw.write(1+"\n");
                else
                    bw.write(0+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}