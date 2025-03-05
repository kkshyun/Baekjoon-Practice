import java.io.*;
import java.util.*;

public class Main {
    static Map<Long,Long> d;
    static int A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);
        d = new HashMap<>();

        bw.write(bfs()+"\n");
        bw.flush();
        bw.close();

    }
    public static long bfs() {
        PriorityQueue<long[]> queue = new PriorityQueue<>((o1,o2)->Long.compare(o1[1],o2[1]));
        queue.add(new long[]{A,0});
        while(!queue.isEmpty()) {
            long[] poll = queue.poll();
            if(d.containsKey(poll[0]))
                continue;
            d.put(poll[0],poll[1]);
            if(poll[0]==B)
                return d.get(poll[0])+1;
            if(poll[0]*2<B+1)
                queue.add(new long[]{poll[0]*2,poll[1]+1});
            if(poll[0]*10+1<B+1)
                queue.add(new long[]{poll[0]*10+1,poll[1]+1});
        }
        return -1;
    }
}