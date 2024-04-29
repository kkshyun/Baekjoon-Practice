import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String[] result = new String[num];
        for(int i = 0; i < num; i++) {
            String str = br.readLine();

            String[] arr = str.split("");

            for(int j = 0; j<arr.length;j++) {
                if(!stack.isEmpty() && stack.peek().equals("(")  && arr[j].equals(")")) {
                    stack.pop();

                } else
                    stack.push(arr[j]);
            }
            if(stack.isEmpty())
                result[i] = "YES";
            else
                result[i] = "NO";
            stack.clear();
        }
        for(int i = 0; i<num; i++) {
            System.out.println(result[i]);
        }
    }
}
