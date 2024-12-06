import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[100000001];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        arr[1] = 0;
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if(arr[i]==0)
                continue;
            for (int j = i+i; j < arr.length; j+=i) {
                arr[j]=0;
            }
        }

        for (int i = n; i < arr.length; i++) {
            int check = 1;
            if(arr[i]==0)
                continue;
            String s = String.valueOf(arr[i]);
            for (int j = 0; j < s.length()/2; j++) {
                if(s.charAt(j)!=s.charAt(s.length()-1-j)) check=0;
            }
            if(check==1) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
