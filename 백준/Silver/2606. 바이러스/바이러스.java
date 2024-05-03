import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, List<Integer>> map;
    static boolean[] check = new boolean[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < pair; i++) {
            String[] arr = br.readLine().split(" ");
            int parent = Integer.parseInt(arr[0]);
            int child = Integer.parseInt(arr[1]);

            List<Integer> childList = map.getOrDefault(parent, new ArrayList<>());
            childList.add(child);
            map.put(parent,childList);
            List<Integer> parentList = map.getOrDefault(child, new ArrayList<>());
            parentList.add(parent);
            map.put(child,parentList);
        }

        dfs(1);
        for (int i = 2; i < 101; i++) {
            if(check[i]) {
                count++;
            }
        }
        System.out.println(count);

    }
    public static void dfs(int node) {
        check[node] = true;
        List<Integer> childList = map.getOrDefault(node,new ArrayList<>());
        for(Integer child : childList) {
            if(!check[child]) {
                dfs(child);
            }
        }

    }
}
