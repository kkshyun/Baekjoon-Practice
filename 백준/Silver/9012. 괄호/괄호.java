import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0 ; i < T ; i++ ) {
            stack.clear();
            boolean vps = true;
            String str = br.readLine();
            for (int j = 0; j < str.length() ; j++) {
                char target = str.charAt(j);
                if(!stack.isEmpty() && target==')') {
                    if(stack.peek()=='(')
                        stack.pop();
                    else {
                        vps = false;
                        break;
                    }
                } else
                    stack.add(target);
            }
            if(stack.isEmpty() && vps)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.print(sb);
    }
}