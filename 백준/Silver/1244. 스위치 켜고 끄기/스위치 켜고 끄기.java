import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num ; i++ ) {
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1")) {
                executeBoy(Integer.parseInt(st.nextToken()));
            } else
                executeGirl(Integer.parseInt(st.nextToken()));
        }
        for(int i = 1 ; i <= N ; i++) {
            sb.append(arr[i]).append(" ");
            if(i % 20 == 0)
                sb.append("\n");
        }
        System.out.print(sb);
        
    }
    static void executeBoy(int num) {
        for(int i = 1 ; i <= N ; i++) {
            if(i % num == 0) {
                arr[i] = arr[i]==1?0:1;
            }
        }
    }

    static void executeGirl(int num) {
        arr[num] = arr[num]==1?0:1;
        int left = num -1;
        int right = num +1;
        while(true) {
            if(left <= 0 || right > N)
                return;
            if(arr[left] == arr[right]) {
                arr[left] = arr[left]==1?0:1;
                arr[right] = arr[right]==1?0:1;
                left--;
                right++;
            } else
                return;
        }
    }
}