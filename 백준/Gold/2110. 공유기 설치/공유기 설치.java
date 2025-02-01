import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int C, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        binarySearch();
        System.out.println(answer);
    }
    public static void binarySearch() {
        int start = 1;
        int end = arr[arr.length-1] - arr[0];
        while(start < end) {
            int mid = (start+end) / 2;
            int startValue = arr[0];
            int count = 1;
            for (int i = 1; i < arr.length; i++) {
                if(startValue+mid>=arr[i])
                    continue;
                count++;
                startValue = arr[i];
            }
            if(count>=C) {
                start = mid + 1;

            } else {
                end = mid;

            }
        }
        answer = start;
    }
}