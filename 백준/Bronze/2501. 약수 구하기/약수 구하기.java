import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        List<Integer> list = new LinkedList<>();
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        for (int i = 1; i <= N; i++) {
            if(N%i==0)
                list.add(i);
        }
        Collections.sort(list);
        if(list.size()<K)
            bw.write("0\n");
        else
            bw.write(list.get(K-1)+"\n");
        bw.flush();
        bw.close();
    }
}
