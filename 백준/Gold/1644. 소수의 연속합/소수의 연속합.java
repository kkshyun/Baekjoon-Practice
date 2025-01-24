import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[num+1];
        Arrays.fill(arr,true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(!arr[i])
                continue;
            for (int j = i*2; j <= num; j+=i) {
                arr[j] = false;
            }
        }

        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i])
                count++;
        }
        int[] primeArr = new int[count];
        int primeCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(primeCount == count)
                break;
            if(arr[i]== true) {
                primeArr[primeCount] = i;
                primeCount++;
            }
        }

        int startIndex = 0;
        int endIndex = 0;
        int sum = 0;
        int result = 0;
        while(true) {
            if(sum >= num) {
                sum -= primeArr[startIndex++];
            } else if(endIndex==primeArr.length) {
                break;
            } else {
                sum += primeArr[endIndex++];
            }

            if(sum == num)
                result++;
        }

        System.out.println(result);

    }
}