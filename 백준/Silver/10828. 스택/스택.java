import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N ; i++ ) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" :
                        stack.push(Integer.parseInt(st.nextToken()));
                        break;
                case "pop" :
                        if(stack.isEmpty())
                            sb.append("-1\n");
                        else
                            sb.append(stack.pop()).append("\n");
                        break;
                case "size" :
                        sb.append(stack.size()).append("\n");
                        break;
                case "empty" :
                        if(stack.isEmpty())
                            sb.append("1\n");
                        else
                            sb.append("0\n");
                        break;
                case "top" :
                        if(stack.isEmpty())
                            sb.append("-1\n");
                        else
                            sb.append(stack.peek()).append("\n");
                        break;
            }
        }
        System.out.print(sb);
    }
}