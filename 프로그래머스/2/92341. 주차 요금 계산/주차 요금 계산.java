import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalFees = new HashMap<>();
        Map<String, String> entrances = new HashMap<>();
        for(String r : records) {
            String[] arr = r.split(" ");
            int period = 0;
            if(arr[2].equals("IN")) {
                entrances.put(arr[1], arr[0]);
                continue;
            } else {
                String[] inTime = entrances.get(arr[1]).split(":");
                int inHour = Integer.parseInt(inTime[0]);
                int inMinute = Integer.parseInt(inTime[1]);
                String[] outTime = arr[0].split(":");
                int outHour = Integer.parseInt(outTime[0]);
                int outMinute = Integer.parseInt(outTime[1]);
                int in = inHour * 60 + inMinute;
                int out = outHour * 60 + outMinute;

                period = out - in;
                entrances.remove(arr[1]);
            }
            totalFees.put(arr[1], totalFees.getOrDefault(arr[1],0)+period);
        }
        
        for(Map.Entry<String, String> entry : entrances.entrySet()) {
            String[] outTime = entry.getValue().split(":");
            int outHour = Integer.parseInt(outTime[0]);
            int outMinute = Integer.parseInt(outTime[1]);
            int out = outHour * 60 + outMinute;
            int period = 23*60 + 59 - out;
           
            totalFees.put(entry.getKey(), totalFees.getOrDefault(entry.getKey(),0)+period);
        }
        
        int[] answer = new int[totalFees.size()];
        Map<String, Integer> sortedMap = new TreeMap<>(totalFees);
        int count = 0;
        for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            int total = entry.getValue();
            
            if(entry.getValue() <= fees[0]) {
                answer[count] = fees[1];
            }
            else {
                int extra = total - fees[0];
                int unit =
                    (extra + fees[2] - 1) / fees[2];
                answer[count] =
                    fees[1] + unit * fees[3];
            }
            
            count++;
        }
        return answer;
    }
}