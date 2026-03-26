import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Entry {
        long num;
        int value;
        public Entry(long num, int value) {
            this.num = num;
            this.value = value;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        PriorityQueue<Entry> pq = new PriorityQueue<>((o1,o2)-> {
            if(o1.value == o2.value)
                return Long.compare(o1.num, o2.num);
            return o2.value - o1.value;
        });
        for(int i = 0 ; i < N ; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(long key : map.keySet()) {
            pq.add(new Entry(key, map.get(key)));
        }
        System.out.print(pq.poll().num);
    }
}