import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dpInc = new int[N];
        int[] dpDes = new int[N];
        int[] result = new int[N];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            dpInc[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j])
                    dpInc[i] = Math.max(dpInc[j]+1,dpInc[i]);
            }
        }
        for (int i = arr.length-1; i >= 0; i--) {
            dpDes[i] = 1;
            for (int j = arr.length-1; j >= i; j--) {
                if(arr[i] > arr[j])
                    dpDes[i] = Math.max(dpDes[j]+1,dpDes[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            result[i] = dpInc[i] + dpDes[i] - 1;
        }
        Arrays.sort(result);
        bw.write(result[result.length-1]+"\n");
        bw.flush();
        bw.close();
    }
}