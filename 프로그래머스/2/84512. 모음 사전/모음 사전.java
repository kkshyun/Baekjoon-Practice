class Solution {
    String[] vowels = {"A", "E", "I", "O", "U"};
    int count = 0;
    int answer = 0;

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    public void dfs(String current, String target) {
        if(answer != 0) return;
        if(current.length() == 5) return;

        for(String v : vowels) {
            String next = current + v;
            count++;

            if(next.equals(target)) {
                answer = count;
                return;
            }

            dfs(next, target);
        }
    }
}