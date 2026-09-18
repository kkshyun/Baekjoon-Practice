import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        // 간선 정렬
        Arrays.sort(costs, (a,b)->Integer.compare(a[2],b[2]));
        parent = new int[n];
        for(int i = 0 ; i < n ; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        int count = 0;
        
        for (int[] edge : costs) {

            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            // 서로 다른 집합이면 연결
            if (find(a) != find(b)) {

                union(a, b);

                answer += cost;
                count++;

                if (count == n - 1) {
                    break;
                }
            }
        }
        return answer;
    }
    
    static int find(int x) {
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }
}