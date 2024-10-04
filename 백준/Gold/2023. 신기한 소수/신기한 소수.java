import java.io.*;

public class Main {
    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        DFS(1,2);
        DFS(1,3);
        DFS(1,5);
        DFS(1,7);
        bw.flush();
        bw.close();
    }

    public static void DFS(int digit, long s) throws IOException {
        if(!checkPrimeNumber(s))
            return;
        if(digit == n)
            bw.write(s + "\n");
        digit++;
        long num = s*10;
        for (int i = 1; i <= 9; i+=2) { // 1,3,5,7,9
            DFS(digit,num+i);
        }
    }

    public static boolean checkPrimeNumber(long n) {
        for (int i = 2; i < n/2; i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
