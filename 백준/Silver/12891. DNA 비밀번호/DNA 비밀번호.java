import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        Map<Character, Integer> map = new HashMap<>();

        map.put('A',Integer.parseInt(st.nextToken()));
        map.put('C',Integer.parseInt(st.nextToken()));
        map.put('G',Integer.parseInt(st.nextToken()));
        map.put('T',Integer.parseInt(st.nextToken()));

        Map<Character, Integer> window = new HashMap<>();
        window.put('A',0);
        window.put('C',0);
        window.put('G',0);
        window.put('T',0);
        // 윈도우크기만큼 초기화
        for (int i = 0; i < P; i++) {
            window.put(str.charAt(i),window.get(str.charAt(i)) + 1);
        }
        int count = 0;
        boolean check = true;
        for(Character key : map.keySet()) {
            if(map.get(key) > window.get(key)) {
                check = false;
                break;
            }
        }
        if(check) {
            count++;
        }

        for(int i = 1; i <= S-P; i++) {
            window.put(str.charAt(i-1), window.get(str.charAt(i-1)) - 1);
            window.put(str.charAt(i+P-1), window.get(str.charAt(i+P-1)) + 1);
            check = true;
            for(Character key : map.keySet()) {
                if(map.get(key) > window.get(key)) {
                    check = false;
                    break;
                }
            }
            if(check) {
                count++;
            }
        }
        System.out.println(count);
    }
}