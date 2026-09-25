import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        
        for(int i = 1 ; i <= order.length; i++) {
            queue.offer(i);
        }
        
        for(int i : order) {
            if(!stack.isEmpty() && stack.peek() == i) {
                answer++;
                stack.pop();
                continue;
            }
            
            if(queue.isEmpty())
                break;
            
            while(!queue.isEmpty() && queue.peek() != i) {
                stack.push(queue.poll());
            }
            
            if(!queue.isEmpty() && queue.peek() == i) {
                answer++;
                queue.poll();
            }
            
        }
        
        return answer;
    }
}