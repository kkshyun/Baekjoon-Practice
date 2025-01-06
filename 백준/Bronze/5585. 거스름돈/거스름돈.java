import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        money = 1000 - money;
        int[] coins = new int[6];
        coins[0] = 1;
        coins[1] = 5;
        coins[2] = 10;
        coins[3] = 50;
        coins[4] = 100;
        coins[5] = 500;
        int count = 0;
        for (int i = 5; i >= 0 ; i--) {
            if(money == 0)
                break;
            if(money < coins[i])
                continue;
            count += money / coins[i];
            money = money % coins[i];
        }
        System.out.println(count);
    }
}