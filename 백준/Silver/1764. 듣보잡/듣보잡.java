import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < N ; i++) {
            set.add(br.readLine());
        }
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < M ; i++) {
            String name = br.readLine();
            if(set.contains(name)) {
                result.add(name);
            }
        }
        Collections.sort(result);
        sb.append(result.size()).append("\n");
        for (String n : result) {
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }
}