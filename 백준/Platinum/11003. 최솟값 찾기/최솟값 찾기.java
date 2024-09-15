import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<int[]> deque = new ArrayDeque<>();
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int L = Integer.parseInt(str[1]);
        int[] numArr = new int[N];
        int[] result = new int[N];
        str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(str[i]);
        }

        deque.addLast(new int[] {0, numArr[0]});
        bw.write(numArr[0] + " ");


        for(int i = 1 ; i < N ; i++) {
            while (deque.size()!=0) {
                // 넣으려는 수보다 마지막에 존재하는 값이 크거나 같을 때 마지막 제거
                if(deque.getLast()[1] >= numArr[i]){
                    deque.removeLast();
                }
                // 넣으려는 수보다 마지막에 존재하는 값이 작을 때
                else {
                    break;
                }
            }
            deque.addLast(new int[] {i, numArr[i]});

//            System.out.println("원소");
//            for(List l : deque) {
//                System.out.print(l);
//            }

            // 윈도우 크기 : L 비교
            // 만약 L이 3이고 i 10이면 8 9 10까지만 오케이

            int first = deque.getFirst()[0];
            while(deque.size()!=1 && i-L+1>0 && first < i-L+1 ) {
                deque.removeFirst();
                first = deque.getFirst()[0];
            }

            bw.write(deque.getFirst()[1] + " ");
//            System.out.println("result"+result[i]);
        }
        bw.flush();
        bw.close();
    }
}