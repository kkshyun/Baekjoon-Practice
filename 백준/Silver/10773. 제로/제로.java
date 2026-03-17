import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int temp;
        for (int i = 0; i < K ; i++) {
            temp = Integer.parseInt(br.readLine()); 
            if(temp == 0)
                stack.pop();
            else
                stack.push(temp);
        }
        long sum = 0;
        for (int num : stack) {
            sum += num;
        }
        System.out.print(sum);
    }
}