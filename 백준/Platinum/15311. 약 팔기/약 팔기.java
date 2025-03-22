import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write("2000\n");
        int sum = 0;
        for (int i = 0; i < 1000; i++)
            bw.write(1+" ");
        for (int i = 1000; i < 2000; i++)
            bw.write(999+" ");
        bw.flush();
        bw.close();
    }
}