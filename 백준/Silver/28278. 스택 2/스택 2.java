import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            if(s[0].equals("1")) {
                stack.addLast(Integer.parseInt(s[1]));
            } else if(s[0].equals("2")) {
                if(stack.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(stack.removeLast()+"\n");
            } else if(s[0].equals("3")) {
                bw.write(stack.size()+"\n");
            } else if(s[0].equals("4")) {
                if(stack.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0\n");
            } else if(s[0].equals("5")) {
                if(stack.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(stack.peekLast()+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
