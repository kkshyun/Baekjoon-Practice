import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();
        int count = 0;
        boolean groupWord = true;
        for (int i = 0; i < N ; i++) {
            String str = br.readLine();
            set.clear();
            char beforeChar = str.charAt(0);
            set.add(beforeChar);
            groupWord = true;
            
            for (int j = 1; j < str.length() ; j++) {
                char next = str.charAt(j);
                if(beforeChar != next && set.contains(next)) {
                    groupWord = false;
                    break;
                }
                beforeChar = next;
                set.add(next);
            }
            if(groupWord)
                count++;
        }
        System.out.print(count);
    }
}