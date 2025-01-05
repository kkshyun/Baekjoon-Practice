import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static class Edge{
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int W = Integer.parseInt(s[2]);
            long[] dist = new long[N+1];
            int check = 0;
            long max = 10000000000l;
            Arrays.fill(dist, max);
            dist[1] = 0;
            ArrayList<Edge> edges = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                int time = Integer.parseInt(s[2]);
                edges.add(new Edge(start,end,time));
                edges.add(new Edge(end,start,time));
            }
            for (int j = 0; j < W; j++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                int time = Integer.parseInt(s[2]);
                edges.add(new Edge(start,end,time*(-1)));
            }
            // 모든 점에서 사이클이 있는지 확인
            // 최단거리 구하면 출발을 하였을때보다 시간이 되돌아가져 있는지 확인 가능

            for (int j = 0; j < N-1; j++) {
                for (Edge edge : edges) {
                    if(dist[edge.end]>dist[edge.start]+edge.cost) {
                        dist[edge.end]=dist[edge.start]+edge.cost;
                    }
                }
            }
            for (Edge edge : edges) {
                if(dist[edge.end]>dist[edge.start]+edge.cost) {
                    check = 1;
                    break;
                }
            }


            if(check==1)
                bw.write("YES\n");
            else
                bw.write("NO\n");

        }
        bw.flush();
        bw.close();
    }
}
