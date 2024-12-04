import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num>=1) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }

        Collections.sort(negatives);
        Collections.sort(positives,Collections.reverseOrder());
//        for (Integer num : negatives) {
//            if (num != null) {
//                System.out.print(num);
//            }
//        }
//        for (Integer num : positives) {
//            if (num != null) {
//                System.out.print(num);
//            }
//        }


        // 2이상 양수끼리는 최대한 둘씩 짝짓기
        // 1은 각각 더하는게 오히려 나음
        // 0은 -가 홀수개일때 없앨 수 있음

        int sum = 0;

        // 4 3 2
        for (int i = 0; i < positives.size(); i+=2) {
            int temp = 0;
            int getI = positives.get(i);
            if(i==positives.size()-1) {
                sum += getI;
                break;
            }
            temp = getI * positives.get(i+1);
            if(getI != temp) {
                sum += temp;
            }else {
                sum += temp + 1;
            }
        }


        // -9 -8 -1 0
        for (int i = 0; i < negatives.size(); i+=2) {
            int temp = 0;
            Integer getI = negatives.get(i);
            if(i==negatives.size()-1) {
                sum += getI;
                break;
            }
            temp = getI * negatives.get(i+1);
            sum += temp;
        }

        System.out.println(sum);
    }
}
