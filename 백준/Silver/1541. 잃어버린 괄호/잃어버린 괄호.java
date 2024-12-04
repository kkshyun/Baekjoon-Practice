import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();
        String[] numbers = original.split("-|\\+");
        String[] str = original.split("");

        int result = 0;
        int count = 0;
        int check = 1;

        result += Integer.parseInt(numbers[0]);
        count++;

        for(String sCheck : str) {
            if(sCheck.equals("-")||sCheck.equals("+")) {
                if(sCheck.equals("-")) {
                    check = -1;
                }
                result += Integer.parseInt(numbers[count])*check;
                count++;
            }
        }
        System.out.println(result);

    }
}
