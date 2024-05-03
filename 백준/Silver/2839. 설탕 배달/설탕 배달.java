import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.InterruptedByTimeoutException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = -1;
        int temp = -1;

        int share3 = num / 3;
        int remain3 = num % 3;
        if(remain3 == 0) {
            result = share3;
        }

        int share5 = num / 5;
        for (int i = share5; i >= 1; i--) {
            int remain5 = num - i*5;
            if(remain5 % 3 == 0) {
                share3 = remain5 / 3;
                temp = i + share3;
                break;
            }
        }

        if(result!= -1 && temp!= -1) {
            if(result < temp)
                System.out.println(result);
            else
                System.out.println(temp);
        }else {
            if(result <= temp)
                System.out.println(temp);
            else
                System.out.println(result);
        }
    }
}
