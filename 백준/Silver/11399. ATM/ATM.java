import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        for (int i = 1; i < n; i++) {
            int target = arr[i];
            int index = i;
            for (int j = 0; j < i; j++) {
                if(target<arr[j]) {
                    index = j;
                    break;
                }
            }
            for(int j = i-1 ; j >= index ;j--) {
                arr[j+1]=arr[j];
            }
            arr[index] = target;
        }

        int[] S = new int[n];
        S[0] = arr[0];
        int sum = S[0];
        for (int i = 1; i < n; i++) {
            S[i] = S[i-1] + arr[i];
            sum += S[i];
        }
        System.out.println(sum);
    }
}
