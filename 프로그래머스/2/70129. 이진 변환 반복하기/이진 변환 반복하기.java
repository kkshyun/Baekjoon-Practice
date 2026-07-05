class Solution {
    public int[] solution(String s) {
        int after = 0;
        int loop = 0;
        int count = 0;
        String result = s;
        while(true) {
            if(result.equals("1"))
                break;
            loop++;
            after = 0;
            for(int i = 0; i < result.length(); i++) {
                if(result.charAt(i) =='1')
                    after++;
                else
                    count++;
            }
            result = Integer.toString(after, 2);
            
        }
        
        
        int[] answer = {loop, count};
        return answer;
    }
}