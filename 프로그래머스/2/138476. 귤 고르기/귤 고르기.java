import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine) {
            map.put(t,map.getOrDefault(t,0)+1);
        }
        
        List<Map.Entry<Integer, Integer>> sortList = new ArrayList<>(map.entrySet());
        sortList.sort((a,b) -> Integer.compare(b.getValue(),a.getValue()));
        
        int answer = 0;
        for(Map.Entry<Integer, Integer> entry : sortList) {
            if(k <= 0)
                return answer;
            k -= entry.getValue();
            answer++;
        }
        return answer;
    }
}