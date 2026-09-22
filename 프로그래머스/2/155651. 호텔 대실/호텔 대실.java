import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Queue<Integer> queue = new ArrayDeque<>();
        Arrays.sort(book_time, (a,b)->a[0].compareTo(b[0]));
        for(String[] t : book_time) {
            String[] s = t[0].split(":");
            int startTime = Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]);
            s = t[1].split(":");
            int endTime = Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]) + 10;
            boolean input = false;
            int count = 0;
            while(count <= queue.size() && !queue.isEmpty()) {
                int time = queue.poll();
                count++;
                if(time <= startTime) {
                    input = true;
                    queue.offer(endTime);
                    break;
                } else {
                    queue.offer(time);
                }
            }
            if(!input)
                queue.offer(endTime);

        }
        return queue.size();
    }
}