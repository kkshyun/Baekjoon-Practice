import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min;
    static String[] result = new String[3];
    static int N;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            min = 1000000;
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new String[N];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = st.nextToken();
            }
            if (N > 32) {
                sb.append(0).append("\n");
                continue;
            }
            combination(0,0);
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
    public static void combination(int r, int start){
        if(r == 3) {
            int temp = 0;
            for (int i = 0; i < 4; i++) {
                temp += (result[1].charAt(i) != result[2].charAt(i)) ? 1 : 0;
                temp += (result[1].charAt(i) != result[0].charAt(i)) ? 1 : 0;
                temp += (result[2].charAt(i) != result[0].charAt(i)) ? 1 : 0;
            }
            min = Math.min(min, temp);
            return;
        }
        for (int i = start; i < N; i++) {
            result[r] = arr[i];
            combination(r+1, i+1);
        }
    }
}