import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i <N; i++) {
            set.add(br.readLine());
        }
        String[] arr = set.toArray(new String[0]);
        Arrays.sort(arr, (s1, s2)-> {
            if(s1.length() == s2.length())
                return s1.compareTo(s2);
            return s1.length() - s2.length();
        });
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}