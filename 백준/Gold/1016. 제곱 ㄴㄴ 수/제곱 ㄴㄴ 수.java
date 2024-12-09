import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long min = Long.parseLong(s[0]);
        long max = Long.parseLong(s[1]);

        boolean[] check = new boolean[(int) (max-min+1)];
        for (long i = 2; i <= Math.sqrt(max); i++) {
            long power = i*i;
            long start_index  = (min%power==0?min/power:min/power+1);
            for (long j = start_index; j<=max/power; j++) {
                check[(int) (j*power-min)]=true;
            }
//            while(start_index*power<=max) {
//                check[(int) (start_index*power-min)]=true;
//                start_index++;
//            }
        }
        int count = 0;
        for (int i = 0; i < check.length; i++) {
            if(!check[i]){
                count++;
            }

        }
        System.out.println(count);
    }
}