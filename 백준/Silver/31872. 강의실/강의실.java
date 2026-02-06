import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] classes = new int[N+1];
        int[] term = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            classes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(classes);
        // 0 1 4 6 8 9
        for (int i = 1; i <= N; i++) {
            term[i] = classes[i] - classes[i-1];
        }
        Arrays.sort(term);
        int result = classes[N] - classes[0];
        for (int i = 0 ; i < K; i++) {
            result -= term[N-i];
        }
        System.out.println(result);
    }
}