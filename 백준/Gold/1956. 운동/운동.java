import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);

        long[][] dist = new long[V+1][V+1];
        long max = 100000000l;
        for (int i = 0; i < V + 1; i++) {
            Arrays.fill(dist[i],max);
        }
        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            long cost = Integer.parseInt(s[2]);
            dist[start][end] = cost;
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 1; k <= V; k++) {
                    if(dist[j][i]!=max && dist[i][k]!=max && dist[j][k] > dist[j][i]+dist[i][k])
                        dist[j][k] = dist[j][i]+dist[i][k];
                }
            }
        }

        long min = dist[1][1];
        for (int i = 1; i <= V; i++) {
            if(min > dist[i][i])
                min = dist[i][i];
        }

        if(min == max)
            System.out.println("-1");
        else
            System.out.println(min);

    }
}