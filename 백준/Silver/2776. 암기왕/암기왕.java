import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] note1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            note1 = new int[N];
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                note1[j] = Integer.parseInt(s[j]);
            }
            Arrays.sort(note1);

            int M = Integer.parseInt(br.readLine());
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                bw.write(binarySearch(Integer.parseInt(s[j]))+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static int binarySearch(int num) {
        int start = 0;
        int end = note1.length-1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(note1[mid] == num)
                return 1;
            else if(note1[mid] < num)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return 0;
    }

}