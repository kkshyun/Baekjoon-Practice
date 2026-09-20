import java.util.*;

class Solution {
    static Map<String, Integer> dist;
    public int solution(String begin, String target, String[] words) {
        dist = new HashMap<>();
        
        return bfs(begin, target, words);
    }
    
    static int bfs(String b, String t, String[] w) {
        dist.put(b, 0);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(b);
        while(!queue.isEmpty()) {
            String s = queue.poll();
            
            for(String next : w) {
                if(dist.containsKey(next))
                    continue;
                int count = 0;
                for(int i = 0 ; i < next.length(); i++) {
                    if(s.charAt(i) != next.charAt(i)) {
                        count++;
                        if(count >= 2)
                            break;
                    }
                }
                if(count != 1)
                    continue;
                if(next.equals(t))
                        return dist.get(s)+1;
                dist.put(next, dist.get(s)+1);
                queue.offer(next);
            }
        }
        return 0;
    }
}