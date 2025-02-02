import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(s[i]));
        }
        Collections.sort(list);
        System.out.println(list.get(0)+" "+list.get(list.size()-1));
    }
}