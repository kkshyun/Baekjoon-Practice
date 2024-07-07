import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] numArr = new int[n+1];
        int[] numSum = new int[n+1];
        int[] result = new int[m];
        
        for(int i = 1 ; i < n+1 ; i++){
           numArr[i] = sc.nextInt();
           numSum[i] = numSum[i-1] + numArr[i];
        }

        for(int i = 0 ; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            result[i] = numSum[end] - numSum[start-1];
        }
        for(int i = 0 ;i < m ;i++) {
            System.out.println(result[i]);
        }
    }
}
