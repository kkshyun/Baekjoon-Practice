import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][2];
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 위치
            arr[i][1] = Integer.parseInt(st.nextToken()); // 높이
        }
        Arrays.sort(arr, (o1,o2)->{
            return Integer.compare(o1[0], o2[0]);
        });
        for (int i = 0; i < arr.length; i++) {
            if(arr[maxIndex][1] < arr[i][1])
                maxIndex = i;
        }
        int sum = arr[maxIndex][1];

        int maxLength = arr[0][1];
        for (int i = 0; i < maxIndex; i++) {
            maxLength = Math.max(maxLength,arr[i][1]);
            sum += maxLength * (arr[i+1][0] - arr[i][0]);
        }
        maxLength = arr[arr.length-1][1];
        for (int i = arr.length-1; i > maxIndex; i--) {
            maxLength = Math.max(maxLength,arr[i][1]);
            sum += maxLength * (arr[i][0] - arr[i-1][0]);
        }
        System.out.println(sum);
    }
}