public class Main {
    static boolean[] arr;
    public static void main(String[] args) {
        arr = new boolean[10001];
        for (int i = 0; i < 10001; i++) {
            d(i);
        }
        for (int i = 1; i < 10001; i++) {
            if(arr[i]==false)
                System.out.println(i);
        }
    }
    public static void d(int n) {
        int sum = n;
        // 자릿수 계산하기
        while(n>0) {
            sum += n % 10;
            n /=10;
        }
        if(sum<=10000) {
            arr[sum] = true;
        }
    }
}