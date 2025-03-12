import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        boolean[] primes = new boolean[5000000+1];
        Arrays.fill(primes,true);
        primes[0] = false;
        primes[1] = false;
        List<Integer> list = new LinkedList<>();
        for (int i = 2; i <= Math.sqrt(primes.length-1); i++) {
            if(primes[i]) {
                list.add(i);
                for (int j = i+i; j < primes.length; j+=i) {
                    primes[j] = false;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for(Integer integer : list) {
                if (integer * integer > temp) break;
                while(temp%integer==0) {
                    temp /= integer;
                    bw.write(integer+" ");
                }
            }
            if (temp > 1) bw.write(temp + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
