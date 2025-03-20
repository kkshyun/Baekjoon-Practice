import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int M,A,B;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);
        int N = Integer.parseInt(s[2]);
        visited = new boolean[100001];
        M = Integer.parseInt(s[3]);
        bw.write(bfs(N)+"\n");
        bw.flush();
        bw.close();
    }
    static int bfs(int state) {
//        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{state,0});
        int result = 0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int location = poll[0];
            if(location == M) {
                result = poll[1];
                break;
            }
            if(visited[location])
                continue;
            visited[location] = true;
            if(location+1<=100000 && !visited[location+1])
                queue.add(new int[]{location+1,poll[1]+1});
            if(location-1>=0 && !visited[location-1])
                queue.add(new int[]{location-1,poll[1]+1});
            if(location+A<=100000 && !visited[location+A])
                queue.add(new int[]{location+A,poll[1]+1});
            if(location-A>=0 && !visited[location-A])
                queue.add(new int[]{location-A,poll[1]+1});
            if(location+B<=100000 && !visited[location+B])
                queue.add(new int[]{location+B,poll[1]+1});
            if(location-B>=0 && !visited[location-B])
                queue.add(new int[]{location-B,poll[1]+1});
            if(location*A<=100000 && !visited[location*A])
                queue.add(new int[]{location*A,poll[1]+1});
            if(location*B<=100000 && !visited[location*B])
                queue.add(new int[]{location*B,poll[1]+1});

        }
        return result;
    }
}
