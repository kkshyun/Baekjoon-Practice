import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = arr.length-1;
        int count = 0;
        while(start<end) {
            int sum = arr[start] + arr[end];
            if(sum == x)
                count++;
            if(sum < x) {
                start++;
            } else if(sum >= x) {
                end--;
            }
        }
        System.out.println(count);

    }
}