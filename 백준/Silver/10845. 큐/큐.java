import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push" :
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if(queue.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(queue.poll()).append("\n");
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    if(queue.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "front" :
                    if(queue.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(queue.peekFirst()).append("\n");
                    break;
                case "back" :
                    if(queue.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(queue.peekLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}