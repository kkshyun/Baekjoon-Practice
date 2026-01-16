import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i = arr.length-1; i >= 2 ; i--) {
            if(arr[i] < arr[i-1] + arr[i-2]) {
                max = Math.max(max, arr[i]+arr[i-1]+arr[i-2]);
            }
        }
        if(max == 0)
            System.out.println(-1);
        else
            System.out.println(max);
    }


}