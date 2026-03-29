import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int output = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());
        Set<String> set = new LinkedHashSet<>();
        
        for(int i = 0 ; i < input ; i++) {
            String num = br.readLine();
            if(set.contains(num)) {
                set.remove(num);
                set.add(num);
            } else
                set.add(num);
        }
        int count = 0;
        for(String num : set) {
            sb.append(num).append("\n");
            count++;
            if(count == output)
                break;
        }
        System.out.print(sb);
    }
}