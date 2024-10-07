import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] numArr;
    static int[] findArr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        numArr = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(str[i]);
        }
        int m = Integer.parseInt(br.readLine());
        findArr = new int[m];
        str = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            findArr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(numArr);

        for (int i = 0; i < m; i++) {
            binarySearch(0,n-1,findArr[i]);
        }

        bw.flush();
        bw.close();
    }

    private static void binarySearch(int startIndex, int endIndex, int target) throws IOException {

        int middle = (endIndex+startIndex) / 2;

        if(endIndex-startIndex<0) {
            if(numArr[middle] != target) {
                bw.write("0\n");
            }
            return;
        }

        if(numArr[middle]<target)
            binarySearch(middle+1,endIndex,target);
        else if(numArr[middle]>target)
            binarySearch(startIndex,middle-1,target);
        else if(numArr[middle]==target) {
            bw.write("1\n");

        }
    }
}
