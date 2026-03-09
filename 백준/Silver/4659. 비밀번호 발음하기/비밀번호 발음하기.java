import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        while(true) {
            String str = br.readLine();
            if(str.equals("end"))
                break;

            sb.append("<").append(str).append(">");

            // 첫번째 조건
            boolean firstCheck = false;
            for (int i = 0; i < str.length(); i++) {
                if (set.contains(str.charAt(i))) {
                    firstCheck = true;
                    break;
                }
            }
            if(!firstCheck) {
                sb.append(" is not acceptable.\n");
                continue;
            }

            // 두번째 조건
            int vowelCnt = 0;
            int consonantCnt = 0;
            boolean secondCheck = true;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (set.contains(c)) {
                    vowelCnt++;
                    consonantCnt = 0;
                } else {
                    consonantCnt++;
                    vowelCnt = 0;
                }
                if (vowelCnt == 3 || consonantCnt == 3) {
                    secondCheck = false;
                    break;
                }
            }
            if (!secondCheck) {
                sb.append(" is not acceptable.\n");
                continue;
            }

            // 세번째 조건
            boolean thirdCheck = true;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    char c = str.charAt(i);
                    if (c != 'e' && c != 'o') {
                        thirdCheck = false;
                        break;
                    }
                }
            }
            if (!thirdCheck) {
                sb.append(" is not acceptable.\n");
                continue;
            }
            sb.append(" is acceptable.\n");
        }
        System.out.println(sb);
    }
}