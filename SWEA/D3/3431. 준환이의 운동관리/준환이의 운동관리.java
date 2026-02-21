import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int L, U, X;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            U = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            if(X > U)
                sb.append("#").append(i+1).append(" ").append("-1\n");
            else if(X < L)
                sb.append("#").append(i+1).append(" ").append(L-X).append("\n");
            else
                sb.append("#").append(i+1).append(" ").append("0\n");
        }
        System.out.println(sb);
    }
}
