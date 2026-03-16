import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        List<Integer> widthList = new ArrayList<>();
        List<Integer> lengthList = new ArrayList<>();
        widthList.add(0);
        widthList.add(length);
        lengthList.add(0);
        lengthList.add(width);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("0"))
                widthList.add(Integer.parseInt(st.nextToken()));
            else
                lengthList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(widthList);
        Collections.sort(lengthList);
        int biggestTerm = 0;
        int result = 0;
        for (int i = 0; i < widthList.size() - 1; i++) {
            biggestTerm = Math.max(biggestTerm, widthList.get(i+1) - widthList.get(i));
        }
        result = biggestTerm;
        biggestTerm = 0;
        for (int i = 0; i < lengthList.size() - 1; i++) {
            biggestTerm = Math.max(biggestTerm, lengthList.get(i+1) - lengthList.get(i));
        }
        result *= biggestTerm;
        System.out.println(result);
    }
}