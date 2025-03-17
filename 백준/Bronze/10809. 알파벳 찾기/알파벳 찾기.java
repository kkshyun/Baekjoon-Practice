import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] charArray = br.readLine().toCharArray();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if(!map.containsKey(charArray[i]-'a'))
                map.put(charArray[i]-'a', i);
        }
        for (int i = 0; i <= 'z'-'a'; i++) {
            bw.write(map.getOrDefault(i,-1)+" ");
        }
        bw.flush();
        bw.close();
    }
}