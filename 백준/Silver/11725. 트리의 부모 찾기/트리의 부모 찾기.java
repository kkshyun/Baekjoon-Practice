import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static Map<Integer, List<Integer>> map;
    static Map<Integer, List<Integer>> result;
    static int[] realResult;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        visited = new boolean[n + 1]; // 0,1,2
        for (int i = 0; i < n-1; i++) {
            String[] str = br.readLine().split(" "); // 3 4
            int node1 = Integer.parseInt(str[0]);
            int node2 = Integer.parseInt(str[1]);
            List<Integer> parentlist = map.getOrDefault(node1, new ArrayList<>());
            parentlist.add(node2);
            map.put(node1, parentlist);
            List<Integer> childlist = map.getOrDefault(node2, new ArrayList<>());
            childlist.add(node1);
            map.put(node2,childlist);
        }
//        System.out.println(map);
//        {1=[6, 4], 2=[4], 3=[6, 5], 4=[1, 2, 7], 5=[3], 6=[1, 3], 7=[4]}


        result = new HashMap<>();
        realResult = new int[n+1];
        dfs(1);
//        System.out.println(result);
        for(int i = 2; i<=n;i++) {
            System.out.println(realResult[i]);
        }

    }
    public static void dfs(int node) {
        visited[node] = true;
        List<Integer> children = map.get(node);
        List<Integer> resultChild = new ArrayList<>();
        for(Integer child: children) {
            if(!visited[child]) {
                resultChild.add(child);
                realResult[child] = node;
            }
        }
        result.put(node,resultChild);
        for(Integer child: children) {
            if(!visited[child]) {
                dfs(child);
            }
        }
    }
}
