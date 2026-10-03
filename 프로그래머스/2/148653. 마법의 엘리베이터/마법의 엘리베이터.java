class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int curr = storey % 10;          // 현재 자릿수
            int next = (storey / 10) % 10;   // 다음 자릿수

            if (curr < 5) {
                // 아래로 내려서 현재 자릿수를 0으로
                answer += curr;
            } 
            else if (curr > 5) {
                // 위로 올려서 현재 자릿수를 0으로
                answer += 10 - curr;

                // 올림 발생
                storey += 10;
            } 
            else { // curr == 5
                answer += 5;

                // 다음 자릿수가 5 이상이면 올리는 쪽이 유리
                if (next >= 5) {
                    storey += 10;
                }
            }

            // 현재 자릿수 제거
            storey /= 10;
        }

        return answer;
    }
}