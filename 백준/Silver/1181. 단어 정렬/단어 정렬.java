import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>((o1,o2)-> {
           if(o1.length() == o2.length())
               return o1.compareTo(o2);
           return o1.length() - o2.length();
        });
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < N ; i++) {
            String temp = br.readLine();
            if(!set.contains(temp)) {
                pq.add(temp);
                set.add(temp);
            }
        }
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb);
    }
}