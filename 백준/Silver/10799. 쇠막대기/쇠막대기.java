import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split("");
        Stack<String[]> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            if(stack.isEmpty()) {
                stack.add(new String[]{s1,String.valueOf(i)});
                continue;
            }
            String[] peek = stack.peek();
            String p1 = peek[0];
            int p2 = Integer.parseInt(peek[1]);
            if(s1.equals(")")) {
                stack.pop();
                if(p2==i-1) {
                    count += stack.size();
                }else {
                    count += 1;
                }
            } else
                stack.add(new String[]{"(",String.valueOf(i)});
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}