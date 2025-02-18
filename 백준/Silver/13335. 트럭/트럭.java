import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int weight = 0;

        for (int i = 0; i < n; i++) {
            int truck = trucks[i];

            while (true) {
                if (bridge.size() == w) {  // 다리가 꽉 찼다면 먼저 나갈 트럭 제거
                    weight -= bridge.poll();
                }

                if (weight + truck <= L) {  // 현재 트럭이 다리 위에 올라갈 수 있는 경우
                    bridge.add(truck);
                    weight += truck;
                    time++;  // 1초 경과
                    break;
                } else {
                    bridge.add(0);  // 트럭이 올라갈 수 없으면 빈 공간 유지
                    time++;  // 1초 경과
                }
            }
        }

        // 마지막 트럭이 다리를 완전히 건너는 시간 추가
        time += w;

        System.out.println(time);
    }
}