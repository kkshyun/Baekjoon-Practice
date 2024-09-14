import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int count = 0;

        String[] str = br.readLine().split(" ");
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(str[i]);
        }
        int[] array = Arrays.stream(nArr).sorted().toArray();
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]+" ");
//        }

        int start_index = 0;
        int end_index = array.length-1;

        while(start_index < end_index) {
            if(array[start_index] + array[end_index] < m) {
                start_index++;
            } else if(array[start_index] + array[end_index] > m) {
                end_index--;
            } else if(array[start_index] + array[end_index] == m) {
                count++;
                start_index++;
                end_index--;
            }
        }
        System.out.print(count);
    }
}
