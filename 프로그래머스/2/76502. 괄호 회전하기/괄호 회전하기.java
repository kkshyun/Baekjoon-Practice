import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            Deque<Character> stack = new ArrayDeque<>();
            boolean valid = true;

            for (int j = i; j < i + n; j++) {

                int index = j % n;
                char c = s.charAt(index);

                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);

                } else {

                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }

                    char top = stack.peek();

                    if (c == ')' && top != '(') {
                        valid = false;
                        break;
                    }

                    if (c == '}' && top != '{') {
                        valid = false;
                        break;
                    }

                    if (c == ']' && top != '[') {
                        valid = false;
                        break;
                    }

                    stack.pop();
                }
            }

            if (valid && stack.isEmpty()) {
                count++;
            }
        }

        return count;
    }
}