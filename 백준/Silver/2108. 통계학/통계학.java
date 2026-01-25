import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr);
        sb.append(Math.round((float) sum /N)).append("\n");
        sb.append(arr[N/2]).append("\n");
        int max = map.get(arr[0]);

        PriorityQueue<int[]>  pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) // 값
                return o1[0] - o2[0]; // 키
            return o2[1] - o1[1]; // 값
        });

        for(Integer key : map.keySet()){
            pq.add(new int[]{key, map.get(key)});
        }

        int[] poll = pq.poll();
        int result = poll[0];
        int value = poll[1];
        if(!pq.isEmpty()) {
            poll = pq.poll();
            if(poll[1] == value)
                result = poll[0];
        }
        sb.append(result).append("\n");


        long ans = arr[N-1]-arr[0];
        sb.append(ans).append("\n");
        System.out.println(sb);
    }
}