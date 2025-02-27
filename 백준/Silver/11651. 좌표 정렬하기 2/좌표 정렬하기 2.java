import java.io.*;
import java.util.Arrays;

public class Main {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            arr[i] = new Node(x,y);
        }
        Arrays.sort(arr,(o1,o2)-> {
            if(o1.y == o2.y)
                return o1.x - o2.x;
            else
                return o1.y - o2.y;
        });
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i].x +" "+arr[i].y+"\n");
        }
        bw.flush();
        bw.close();
    }
}