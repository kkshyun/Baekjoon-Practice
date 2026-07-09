import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int count1 = 0, count2 = 0, count3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
            int index = i%first.length;
            if(answers[i] == first[index])
                count1++;
            index = i%second.length;
            if(answers[i] == second[index])
                count2++;
            index = i%third.length;
            if(answers[i] == third[index])
                count3++;
        }
        
        int max = Math.max(count1, Math.max(count2, count3));

        ArrayList<Integer> list = new ArrayList<>();

        if(count1 == max) list.add(1);
        if(count2 == max) list.add(2);
        if(count3 == max) list.add(3);

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}