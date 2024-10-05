import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[][] table;
    static int[][] distance;
    static int count = 0;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        table = new boolean[n][m];
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if(Integer.parseInt(str[j])==1)
                    table[i][j] = true;
                else
                    table[i][j] = false;
            }
        }
        BFS(0,0);
        System.out.print(distance[n - 1][m - 1]);
    }
    private static void BFS(int x, int y) {
        Queue<Element> queue = new LinkedList<Element>();
        queue.add(new Element(x,y));
        table[x][y] = false;
        distance[x][y] = 1;
        while(!queue.isEmpty()) {
            Element poll = queue.poll();
            int pollX = poll.x;
            int pollY = poll.y;
            if(pollX==n-1 && pollY==m-1) {
                return;
            }
            if(pollX != 0 && table[pollX-1][pollY]) {
                queue.add(new Element(pollX-1,pollY));
                table[pollX-1][pollY] = false;
                distance[pollX - 1][pollY] = distance[pollX][pollY] + 1;
            }
            if(pollX != n-1 && table[pollX+1][pollY]) {
                queue.add(new Element(pollX+1,pollY));
                table[pollX+1][pollY] = false;
                distance[pollX + 1][pollY] = distance[pollX][pollY] + 1;
            }
            if(pollY != 0 && table[pollX][pollY-1]) {
                queue.add(new Element(pollX,pollY-1));
                table[pollX][pollY-1] = false;
                distance[pollX][pollY - 1] = distance[pollX][pollY] + 1;
            }
            if(pollY != m-1 && table[pollX][pollY+1]) {
                queue.add(new Element(pollX,pollY+1));
                table[pollX][pollY+1] = false;
                distance[pollX][pollY + 1] = distance[pollX][pollY] + 1;
            }
        }
    }
    static class Element {
        int x;
        int y;

        public Element(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

