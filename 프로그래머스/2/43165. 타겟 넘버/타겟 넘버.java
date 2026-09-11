import java.util.*;
class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        boolean[] visited = new boolean[numbers.length];
        dfs(numbers, 0, 0, target);
        return count;
    }
    void dfs(int[] n, long sum, int depth, int target) {
        if(depth == n.length) {
            if(sum == target)
                count++;
            return;
        }
        dfs(n, sum-n[depth], depth+1, target);
        dfs(n, sum+n[depth], depth+1, target);
    }
}