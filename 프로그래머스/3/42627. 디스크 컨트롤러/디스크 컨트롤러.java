import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {
            // 0 : 작업번호, 1 : 요청시간, 2 : 소요시간
            if(a[2] != b[2])
                return Integer.compare(a[2], b[2]);
            if(a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int time = 0;
        int returnTime = 0;
        
        PriorityQueue<int[]> inputPq = new PriorityQueue<>((a,b)-> {
            // 0 : 작업번호, 1 : 요청시간, 2 : 소요시간
            return Integer.compare(a[1], b[1]);
        });
        
        for(int i = 0 ; i < jobs.length ; i++) {
            inputPq.offer(new int[]{i, jobs[i][0], jobs[i][1]});
        }
        
        while(true) {
            if(inputPq.isEmpty() && pq.isEmpty())
                break;
            while(!inputPq.isEmpty()) {
                int[] curr = inputPq.poll();
                if(time >= curr[1]) {
                    pq.offer(new int[]{curr[0], curr[1], curr[2]});
                } else {
                    inputPq.offer(new int[]{curr[0], curr[1], curr[2]});
                    break;
                }
            }
            if(!pq.isEmpty()) {
                int[] curr = pq.poll();
                System.out.println("curr"+curr[0]);
                time = Math.max(time, curr[1]) + curr[2];
                returnTime += time - curr[1];
                System.out.println("returnTime"+returnTime);
            } else
                time++;
        }
        
        return returnTime/jobs.length;
    }
}