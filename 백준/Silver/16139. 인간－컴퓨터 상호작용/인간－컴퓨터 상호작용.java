import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int[][] sum = new int[26][str.length()+1];
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j < str.length()+1; j++) {
                if(str.charAt(j-1) == (char) (i+'a'))
                    sum[i][j] += 1;
                sum[i][j] += sum[i][j-1];
            }
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] s = br.readLine().split(" ");
            int alphabet = s[0].charAt(0) - 'a';
            int startIndex = Integer.parseInt(s[1]);
            int endIndex =  Integer.parseInt(s[2]) + 1;
            sb.append(sum[alphabet][endIndex] - sum[alphabet][startIndex]).append("\n");
        }
        System.out.println(sb);
    }
}