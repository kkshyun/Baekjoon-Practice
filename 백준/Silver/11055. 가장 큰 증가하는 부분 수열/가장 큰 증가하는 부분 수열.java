import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] result = new int[N];
        for (int i = 0; i < arr.length; i++) {
            result[i] += arr[i];
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]) {
                    result[i] = Math.max(result[i], arr[i] + result[j]);
                }
            }
        }
        Arrays.sort(result);
        System.out.println(result[result.length-1]);

    }
}