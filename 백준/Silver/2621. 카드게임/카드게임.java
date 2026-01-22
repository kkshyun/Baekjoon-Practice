import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static char[] cardColors;
    static int[] cardNumbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        cardColors = new char[5];
        cardNumbers = new int[5];
        for (int i = 0; i < 5; i++) {
            s = br.readLine();
            cardColors[i]= s.charAt(0); // 색깔
            cardNumbers[i] = s.charAt(2) - '0'; // 숫자
        }
        Arrays.sort(cardNumbers);

        boolean sameColor = checkSameColor();
        boolean increaseNumber = checkIncreaseNumber();

        // 색깔 같은지부터 체크
        if(sameColor) {
            if(increaseNumber) {
                System.out.println(cardNumbers[4]+900); // 1번
                return;
            } else {
                System.out.println(cardNumbers[4]+600); // 4번
                return;
            }
        }
        if(increaseNumber) {
            System.out.println(cardNumbers[4]+500); // 5번
            return;
        }
        int result = checkNumberCount();
        if(result == 0)
            System.out.println(cardNumbers[4]+100); // 9번
        else
            System.out.println(result);

    }

    public static boolean checkSameColor() {
        char sameColor = cardColors[0];
        for (int i = 1; i < 5; i++) {
            if(sameColor != cardColors[i])
                return false;
        }
        return true;
    }

    public static boolean checkIncreaseNumber() {
        for (int i = 0; i < 4; i++) {
            if(cardNumbers[i] != cardNumbers[i+1] -1)
                return false;
        }
        return true;
    }

    public static int checkNumberCount() {
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            nums.put(cardNumbers[i], nums.getOrDefault(cardNumbers[i], 0) + 1);
        }
        int result = 0;
        if(nums.containsValue(4)) {
            for(Integer num : nums.keySet()) {
                if(nums.get(num) == 4) {
                    return num+800; // 2번
                }
            }
        } else if(nums.containsValue(3)) {
            if(nums.containsValue(2)) {
                for(Integer num : nums.keySet()) {
                    if(nums.get(num) == 3) {
                        result += num*10;
                    }
                    if(nums.get(num) == 2) {
                        result += num;
                    }
                }
                return result+700; // 3번
            } else {
                for(Integer num : nums.keySet()) {
                    if(nums.get(num) == 3) {
                        return num+400; // 6번
                    }
                }
            }
        } else if(nums.containsValue(2)) {
            int max = 0;
            int min = 0;
            for(Integer num : nums.keySet()) {
                if(nums.get(num) == 2) {
                    if(max == 0)
                        max = num;
                    else if(max < num) {
                        min = max;
                        max = num;
                    } else
                        min = num;
                }
            }
            if(min == 0) {
                return max + 200; //8번
            } else
                return max*10 + min + 300; // 7번
        }
        return 0;
    }
}