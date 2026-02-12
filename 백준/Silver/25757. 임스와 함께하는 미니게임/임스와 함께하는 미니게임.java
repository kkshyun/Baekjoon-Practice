import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int member = checkGameMember(st.nextToken().charAt(0));
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        System.out.println(set.size()/(member-1));
    }

    static int checkGameMember(char game) {
        if(game == 'Y')
            return 2;
        else if(game == 'F')
            return 3;
        return 4;
    }
}