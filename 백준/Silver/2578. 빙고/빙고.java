import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        int[][] find = new int[5][5];
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                find[i][j] = num;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if(arr[k][l] == find[i][j])
                            arr[k][l] = 0;
                    }
                }
                if(check() >= 3) {
                    System.out.println(i*5+j+1);
                    return;
                }
            }
        }
    }

    public static int check() {
        boolean check = true;
        int count = 0;
        // 가로 확인
        for (int i = 0; i < 5; i++) {
            check = true;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != 0)
                    check = false;
            }
            if(check)
                count++;
        }

        // 가로 확인
        for (int i = 0; i < 5; i++) {
            check = true;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != 0)
                    check = false;
            }
            if(check)
                count++;
        }
        // 대각선 확인
        check = true;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] != 0)
                check = false;
        }
        if(check)
            count++;
        check = true;
        for (int i = 0; i < 5; i++) {
            if (arr[i][4-i] != 0)
                check = false;
        }
        if(check)
            count++;
        return count;
    }
}