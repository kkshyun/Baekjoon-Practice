import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i+1] = Integer.parseInt(s[i]);
        }
        Map<Integer,Long>[] map = new Map[N+1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new HashMap<>();
        }
        map[1].put(arr[1], 1L);
        int temp = 0;
        for (int i = 2; i < arr.length-1; i++) {
            for (Map.Entry<Integer, Long> entry : map[i-1].entrySet()) {
                if(entry.getKey()+arr[i]<=20) {
                    temp = entry.getKey()+arr[i];
                    map[i].put(temp, map[i].getOrDefault(temp,0L)+entry.getValue());
                }
                if(entry.getKey()-arr[i]>=0) {
                    temp = entry.getKey()-arr[i];
                    map[i].put(temp, map[i].getOrDefault(temp,0L)+entry.getValue());
                }
            }
        }
        bw.write(map[arr.length-2].get(arr[arr.length-1])+"\n");
        bw.flush();
        bw.close();
    }
}