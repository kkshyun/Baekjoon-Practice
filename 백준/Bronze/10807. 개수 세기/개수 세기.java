import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        String v = br.readLine();
        int count = 0;
        for(String str : s) {
            if(str.equals(v))
                count++;
        }
        System.out.println(count);
    }
}
