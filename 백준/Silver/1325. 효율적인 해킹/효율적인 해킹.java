import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int count;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int N;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        A = new ArrayList[N+1];
        for (int i = 0; i < A.length; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int end = Integer.parseInt(s[0]);
            int start = Integer.parseInt(s[1]);
            A[start].add(end);
        }

        int result = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < A.length; i++){
            if(A[i].size()==0)
                continue;
            count = 0;
            visited = new boolean[N+1];
            visited[i] = true;
            BFS(i);
            if(result < count) {
                result = count;
                list = new ArrayList<>();
                list.add(i);
            }else if(result == count) {
                list.add(i);
            }

        }
        for(int n : list) {
            bw.write(n+" ");
        }
        bw.flush();
        bw.close();

    }
    static void BFS(int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n,1});
        visited[n] = true;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for(int i : A[poll[0]]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i,poll[1]+1});
                    count++;
                }
            }
        }
    }
}
