import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> total = new HashMap<>();
        Map<Integer, Integer> status = new HashMap<>();
        for(int t : topping) {
            total.put(t, total.getOrDefault(t, 0)+1);
        }
        int count = 0;
        for(int t : topping) {
            status.put(t, status.getOrDefault(t, 0)+1);
            if(total.get(t) == 1)
                total.remove(t);
            else
                total.put(t, total.get(t)-1);
            if(status.size() == total.size()) {
                count++;
                
            }
        }
        return count;
    }
}