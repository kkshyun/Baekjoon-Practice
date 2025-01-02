import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static class Edge {
        int startCity;
        int endCity;
        int cost;

        public Edge(int startCity, int endCity, int cost) {
            this.startCity = startCity;
            this.endCity = endCity;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        long[] dist = new long[N+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[1] = 0;
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int time = Integer.parseInt(s[2]);
            edges.add(new Edge(start,end,time));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges.get(j);
                if(dist[edge.startCity]==Long.MAX_VALUE)
                    continue;
                if(dist[edge.endCity]>dist[edge.startCity]+edge.cost) {
                    if(i==N-1) {
                        System.out.println(-1);
                        return;
                    }
                    dist[edge.endCity] = dist[edge.startCity]+edge.cost;
                }
            }
        }
        for (int i = 2; i < N+1; i++) {
            if(dist[i]!=Long.MAX_VALUE)
                System.out.println(dist[i]);
            else
                System.out.println(-1);
        }

    }
}