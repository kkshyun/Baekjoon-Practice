import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0 ; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        Map<String, Integer> currMap = new HashMap<>();
        int answer = 0;
        boolean not = false;
        for(int i = 0 ; i < 10; i++) {
            currMap.put(discount[i], currMap.getOrDefault(discount[i],0)+1);
        }
        for(Map.Entry<String, Integer> entry : wantMap.entrySet()) {
            if(!currMap.containsKey(entry.getKey()) || currMap.get(entry.getKey()) < entry.getValue()) {
                not = true;
                break;
            }
        }
        if(!not)
            answer++;
        
        for(int i = 10 ; i < discount.length; i++) {
            not = false;
            currMap.put(discount[i], currMap.getOrDefault(discount[i],0)+1);
            currMap.put(discount[i-10], currMap.get(discount[i-10]) -1);
            for(Map.Entry<String, Integer> entry : wantMap.entrySet()) {
                if(!currMap.containsKey(entry.getKey()) || currMap.get(entry.getKey()) < entry.getValue()) {
                    not = true;
                    break;
                }
            }
            if(!not)
                answer++;
                
        }
        
        
        return answer;
    }
}