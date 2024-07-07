import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int[] arr = new int[n];
        int highScore = 0;
        int total = 0;
        double sum = 0;
        for(int i = 0 ; i<n ;i++) {
            arr[i] = sc.nextInt();
            if(arr[i]>highScore) {
                highScore = arr[i];
            }
            total += arr[i];
        }
        sum = (double) total / highScore * 100 / n;
        System.out.println(sum);
    }
}
