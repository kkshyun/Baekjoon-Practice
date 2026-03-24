import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
            map.put(num, map.getOrDefault(num,0)+1);
            arr[i] = num;
        }
        Arrays.sort(arr);
        sb.append(Math.round((double)sum / N)).append("\n");
            
        sb.append(arr[N/2]).append("\n");
        
        List<Integer> many = new ArrayList<>();
        int manyMax = 0;
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if(manyMax == value) {
                many.add(key);
            } else if (manyMax < value) {
                manyMax = value;
                many.clear();
                many.add(key);
            }
        }
        Collections.sort(many);
        if(many.size() >= 2)
            sb.append(many.get(1)).append("\n");
        else
            sb.append(many.get(0)).append("\n");
        sb.append(max-min);
        
        System.out.print(sb);
    }
}