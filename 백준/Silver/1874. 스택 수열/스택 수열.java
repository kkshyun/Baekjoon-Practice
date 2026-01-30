import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int lastInput = 0;
        int lastPopIndex = 0;
        while(true) {
            if(lastPopIndex == n){
                break;
            }
            if(stack.isEmpty() || lastInput <= arr[lastPopIndex]) {
                for (int i = lastInput + 1; i <= arr[lastPopIndex]; i++) {
                    lastInput++;
                    stack.push(i);
                    sb.append("+").append("\n");
                }
            }
            if(!stack.isEmpty()&&stack.peek() == arr[lastPopIndex]){
                stack.pop();
                lastPopIndex++;
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}