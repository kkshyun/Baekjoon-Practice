import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        // 인접리스트 초기화하기
        for (int i = 1; i < n+1; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);
            // 양방향 에지이므로 양쪽에 에지를 더해줘야함
            A[s].add(e);
            A[e].add(s);
        }
        int count = 0;
        for (int i = 1; i < n+1; i++) {
            // 방문하지 않은 노드가 없을 때까지 반복
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    
    static void DFS(int v) {
        if(visited[v])
            return;
        visited[v] = true;
        for(int i : A[v]) {
            // 연결 노드 중 방문하지 않았던 노드만 탐색하기
            if(visited[i] == false)
                DFS(i);
        }
    }
}
