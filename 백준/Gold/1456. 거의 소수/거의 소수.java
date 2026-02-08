import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        boolean[] arr = new boolean[10000001];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i <= Math.sqrt(arr.length-1); i++) {
            if(!arr[i])
                continue;
            for (int j = i+i; j < arr.length; j+=i) {
                arr[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < arr.length; i++) {
            if(!arr[i])
                continue;
            long temp = i;
            while(i <= (double)B/temp) {
                if(i >= (double)A/temp)
                    count++;
                temp *= i;
            }
        }
        System.out.println(count);
    }
}