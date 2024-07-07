import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int total = 0;
        String sNum = sc.next();
        String[] cNum = sNum.split("");
        for(int i = 0;i<N;i++) {
            total += Integer.parseInt(cNum[i]);
        }
        System.out.println(total);
    }
}
