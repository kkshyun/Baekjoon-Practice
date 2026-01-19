import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();


        int[] alphabetCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'A';
            alphabetCount[index] += 1;
        }

        // 홀수 개수 확인 및 중간 인덱스 체크
        int count = 0;
        int middleIndex = -1;
        for (int i = 0; i < 26; i++) {
            if(alphabetCount[i] % 2 != 0) {
                count++;
                middleIndex = i;
            }
        }

        if(count > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if(alphabetCount[i] == 0)
                continue;
            alphabetCount[i] = alphabetCount[i]/2;
            while(alphabetCount[i] > 0) {
                sb.append((char) (i + 'A'));
                alphabetCount[i]--;
            }
        }
        String start = sb.toString();
        String middle = middleIndex==-1 ? "" : String.valueOf((char)(middleIndex+'A'));
        String end = sb.reverse().toString();
        System.out.println(start+middle+end);
    }
}