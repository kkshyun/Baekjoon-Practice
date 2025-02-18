import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 1000000; i++) {
            String s = String.valueOf(i);
            int sum = i;
            for (int j = 0; j < s.length(); j++) {
                sum += s.charAt(j)-'0';
            }
            if(sum == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}