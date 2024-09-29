import java.io.*;

public class Main {
    public static int[] A, tmp;
    public static long result = 0;
    // 병합 정렬 이용해서 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        String[] str = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(str[i-1]);

        }
        merget_sort(1,N); // start index, end index 넣기
        System.out.println(result);
    }

    private static void merget_sort(int s, int e) {
        // 재귀함수 종료 조건 -> 원소가 1개일때까지 나누기
        if(e-s < 1)
            return;
        // 분할 : 재귀함수로 구현
        int m = s + (e-s)/2;
        merget_sort(s,m);
        merget_sort(m+1,e);
        // 정복 : 두 그룹 합치기
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m+1;
        while(index1<=m && index2<=e) {
            if(tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
                result += index2 - k;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while(index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}