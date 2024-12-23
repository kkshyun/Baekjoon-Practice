import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int count = 0;
    static int N, M;

    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        for (int i = 1; i <= N ; i++) {
            List result = new ArrayList<Integer>();
            check(i,0,result);
        }
        bw.flush();
        bw.close();

    }
    public static void check(int v, int depth, List<Integer> result) throws IOException {
        depth++;
        result.add(v);
        if (depth == M) {
            for (int i = 0; i < result.size(); i++) {
                bw.write(result.get(i) + " ");
            }
            bw.write("\n");
            result.remove(result.size()-1);
            return;
        }
        for (int i = v; i <= N; i++) {
            check(i, depth, result);
        }
        result.remove(result.size()-1);
    }
}