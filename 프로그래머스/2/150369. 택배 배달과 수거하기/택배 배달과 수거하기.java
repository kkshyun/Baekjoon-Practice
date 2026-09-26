import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int capacitySum = 0;
        int maxIndex = deliveries.length -1;
        List<Integer> deDist = new ArrayList<>();
        List<Integer> piDist = new ArrayList<>();
        
        for(int i = deliveries.length -1 ; i >= 0 ; i--) {
            if(deliveries[i] == 0) {
                continue;
            }
            
            int total = capacitySum + deliveries[i];
            
            if(total <= 0) {
                capacitySum += deliveries[i];
                continue;
            }
            
            int q = (total+cap-1) / cap;
            capacitySum = total - q * cap;
            
            for(int j = 0 ; j < q ; j++) {
                deDist.add(i+1);
            }
        }
        
        capacitySum = 0;
        for(int i = pickups.length -1 ; i >= 0 ; i--) {
            if(pickups[i] == 0) {
                continue;
            }
            
            int total = capacitySum + pickups[i];
            
            if(total <= 0) {
                capacitySum += pickups[i];
                continue;
            }
            
            int q = (total+cap-1) / cap;
            capacitySum = total - q * cap;
            
            for(int j = 0 ; j < q ; j++) {
                piDist.add(i+1);
            }
        }
        
        if(deDist.size() > piDist.size()) {
            for(int i = 0 ; i < piDist.size(); i++) {
                answer += Math.max(deDist.get(i), piDist.get(i));
            }
            for(int i = piDist.size() ; i < deDist.size() ; i++) {
                answer += deDist.get(i);
            }
        } else if(deDist.size() < piDist.size()) {
            for(int i = 0 ; i < deDist.size(); i++) {
                answer += Math.max(deDist.get(i), piDist.get(i));
            }
            for(int i = deDist.size() ; i < piDist.size() ; i++) {
                answer += piDist.get(i);
            }
        } else {
            for(int i = 0 ; i < deDist.size(); i++) {
                answer += Math.max(deDist.get(i), piDist.get(i));
            }
        }
        
        return answer*2;
    }
}