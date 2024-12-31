import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if(map.containsKey(s[i].toUpperCase()))
                map.replace(s[i].toUpperCase(),map.get(s[i].toUpperCase())+1);
            else
                map.put(s[i].toUpperCase(),1);
        }
        int max = 0;
        String result="";
        for(String key : map.keySet()) {
            if(map.get(key)>max) {
                max = map.get(key);
                result = key;
            } else if(map.get(key)==max) {
                result="?";
            }
        }
        System.out.println(result);
    }
}