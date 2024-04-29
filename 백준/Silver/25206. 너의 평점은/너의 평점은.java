import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        double credit = 0;
        double grade = 0;
        double sum = 0;

        double totalCredit = 0;
        double result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0;i<20;i++) {
            String input = br.readLine();
            String[] arr = input.split(" ");
            credit = Double.parseDouble(arr[1]);

            if(arr[2].equals("P")) {
                grade = 0;
            } else {
                totalCredit += credit;
                grade = gradeCal(arr[2]);
            }
            sum += credit * grade;
        }
        if(totalCredit == 0) {
            result = 0;
        } else {
            result = sum / totalCredit;
        }
        System.out.println(result);
    }

    public static double gradeCal(String credit) {
        if(credit.charAt(0)=='A'){
            if(credit.charAt(1)=='+')
                return 4.5;
            else
                return 4.0;
        }else if(credit.charAt(0)=='B'){
            if(credit.charAt(1)=='+')
                return 3.5;
            else
                return 3.0;
        }else if(credit.charAt(0)=='C'){
            if(credit.charAt(1)=='+')
                return 2.5;
            else
                return 2.0;
        }else if(credit.charAt(0)=='D'){
            if(credit.charAt(1)=='+')
                return 1.5;
            else
                return 1.0;
        }else
            return 0.0;
    }
}
