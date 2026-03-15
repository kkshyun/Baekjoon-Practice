import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("\\.");
            map.put(str[1],map.getOrDefault(str[1],0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((o1,o2)->o1.compareTo(o2));
        for (String key : map.keySet()) {
            pq.add(key);
        }
        while(!pq.isEmpty()) {
            String poll = pq.poll();
            sb.append(poll).append(" ").append(map.get(poll)).append("\n");
        }
        System.out.println(sb);
    }
}