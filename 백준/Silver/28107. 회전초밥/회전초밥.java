import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 손님
        int M = Integer.parseInt(s[1]); // 초밥 수
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->{
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j < s.length; j++) {
                queue.add(new int[]{Integer.parseInt(s[j]),i});
            }
        }
        s = br.readLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        int[] result = new int[N];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            while(!queue.isEmpty() && queue.peek()[0] < num) {
                queue.poll();
            }
            if(!queue.isEmpty() && queue.peek()[0] == num) {
                int[] poll = queue.poll();
                result[poll[1]] += 1;
            }
        }


        for (int i = 0; i < result.length; i++) {
            bw.write(result[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}