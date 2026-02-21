import java.io.*;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 2; j < N+2; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int j = 2; j < N+2; j++) {
                if(arr[j-2] >= arr[j] || arr[j-1] >= arr[j] || arr[j+1] >= arr[j] || arr[j+2] >= arr[j])
                    continue;
                int left = Math.max(arr[j-2], arr[j-1]);
                int right = Math.max(arr[j+1], arr[j+2]);
                count += left > right ? arr[j] - left : arr[j] - right;
            }
            sb.append("#").append(i+1).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
