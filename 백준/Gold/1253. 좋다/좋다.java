import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int start_index = 0;
        int end_index = n-1;
        int count = 0;
        for(int target = 0 ; target< n; target++) {
            start_index = 0;
            end_index = n-1;
            while(start_index<end_index) {
                if(arr[start_index]+arr[end_index] < arr[target]) {
                    start_index++;
                }else if(arr[start_index]+arr[end_index] > arr[target]) {
                    end_index--;
                }else if(arr[start_index]+arr[end_index] == arr[target]) {
                    if(start_index!= target && end_index!= target ) {
                        count++;
                        break;
                    } else if(start_index == target) {
                        start_index++;
                    } else if(end_index == target) {
                        end_index--;
                    }
                }
            }
        }
        System.out.print(count);
    }
}
