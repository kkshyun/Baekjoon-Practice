import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String[] s = br.readLine().split(" ");
            int num1 = Integer.parseInt(s[0]);
            int num2 = Integer.parseInt(s[1]);
            if(num1==0&&num2==0)
                break;
            if(num2%num1==0)
                bw.write("factor\n");
            else if(num1%num2==0)
                bw.write("multiple\n");
            else if(num2%num1!=0 && num1%num2!=0)
                bw.write("neither\n");
        }
        bw.flush();
        bw.close();
    }
}