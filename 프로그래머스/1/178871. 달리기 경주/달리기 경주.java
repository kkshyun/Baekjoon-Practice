import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        // players : 등수 -> 선수
        Map<String, Integer> order = new HashMap<>(); // 선수 -> 등수
        for(int i = 0 ; i < players.length; i++) {
            order.put(players[i], i);
        }
        for(String name : callings) {
            int currentOrder = order.get(name);
            String prePlayer = players[currentOrder-1];
            players[currentOrder] = prePlayer;
            players[currentOrder-1] = name;
            order.put(name, currentOrder-1);
            order.put(prePlayer, currentOrder);
        }
        return players;
        
    }
}