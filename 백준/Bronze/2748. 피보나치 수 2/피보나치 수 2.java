import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(fibo(num));
    }

    public static long fibo(int i){
        long temp1 = 0;
        long temp2 = 1;
        long result = 0;
        if(i == 0)
            return 0;
        else if(i == 1)
            return 1;
        else {
            for(int j = 2 ; j <= i ; j++) {
                result = 0;
                result += temp1 + temp2;
                temp1 = temp2;
                temp2 = result;
            }
            return result;
        }

    }
}
