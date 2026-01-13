import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            set.add(str);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(set.contains(str))
                count++;
        }
        System.out.println(count);
    }
}