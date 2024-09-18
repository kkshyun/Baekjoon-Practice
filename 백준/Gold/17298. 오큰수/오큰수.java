import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        stack.push(0);
        for (int i = 1; i < n; i++) {
            // 스택 top 에 있는 값이 넣는 값보다 작을 때 top 에 있는 걸 pop 하기
            while(!stack.isEmpty()&&arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        for (int i = 0; i < result.length; i++) {
            bw.write(result[i]+" ");
        }
        
        bw.flush();
        bw.close();
    }
}
