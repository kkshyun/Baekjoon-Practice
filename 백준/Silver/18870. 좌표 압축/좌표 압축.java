import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        // Set 으로 중복 제거
        // PriorityQueue<Integer> 값 넣기
        // Map 에 값 저장해놓기
        // for 문 돌면서 key 값에 맞는 값 꺼내기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] order = new int[N];
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for (int i = 0; i < N ; i++ ) {
            int num = Integer.parseInt(st.nextToken());
            order[i] = num;
            if(set.contains(num))
                continue;
            else {
                set.add(num);
                pq.add(num);
            }
            // -10 -9 2 4
        }
        int count = 0;
        while(!pq.isEmpty()) {
            int key = pq.poll();
            map.put(key, count);
            count++;
            // -10 -> 0, -9 -> 1, 2 -> 2 , 4 -> 3
        }
        for (int i = 0; i < order.length; i++) {
            sb.append(map.get(order[i])).append(" ");
        }
        System.out.print(sb);
    }
}