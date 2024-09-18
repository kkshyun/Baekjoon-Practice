import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        boolean result = true;

        int n = Integer.parseInt(br.readLine());
        int[] makeArr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            makeArr[i] = Integer.parseInt(br.readLine());
        }

        int currentNumber = 1;
        for (int i = 0; i < n; i++) {
            int target = makeArr[i];

            while(currentNumber <= target) {
                stack.push(currentNumber);
                bf.append("+\n");
                currentNumber++;
            }

            if(stack.peek() == target) {
                stack.pop();
                bf.append("-\n");
            } else {
                System.out.print("NO");
                result = false;
                break;
            }
        }
        if(result)
            System.out.println(bf.toString());
    }
}
