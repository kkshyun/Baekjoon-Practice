import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        int num;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("add")) {
                num = Integer.parseInt(st.nextToken());
                if(!set.contains(num))
                    set.add(num);
            }else if(s.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
                if(set.contains(num))
                    set.remove(num);
            } else if(s.equals("check")) {
                num = Integer.parseInt(st.nextToken());
                if(set.contains(num))
                    sb.append("1\n");
                else
                    sb.append("0\n");
            } else if(s.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
                if(set.contains(num))
                    set.remove(num);
                else
                    set.add(num);
            } else if(s.equals("all")) {
                set.clear();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if(s.equals("empty")) {
                set.clear();
            }
        }
        System.out.println(sb);
    }
}