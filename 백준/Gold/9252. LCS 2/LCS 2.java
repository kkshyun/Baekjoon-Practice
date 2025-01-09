import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[][] remember;
    static char[] charArray1, charArray2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        charArray1 = br.readLine().toCharArray();
        charArray2 = br.readLine().toCharArray();
        int arrayLength1 = charArray1.length;
        int arrayLength2 = charArray2.length;
        remember = new int[arrayLength2+1][arrayLength1+1];
        dp();
        int longDist = remember[arrayLength2][arrayLength1];
        System.out.println(longDist);

        // LCS 길이가 0일 때
        if(longDist==0)
            return;

        // LCS 길이가 0이 아닐 때
        Character[] result = new Character[longDist];
        int col = arrayLength2;
        int row = arrayLength1;

        for (int i = col; i >= 1; i--) {
            for (int j = row; j >= 1; j--) {
                if(remember[i][j]==longDist && charArray2[i-1] == charArray1[j-1]) {
                    result[longDist-1] = charArray2[i-1];
                    longDist--;
                    row--;
                    break;
                }
            }
        }

        for(Character c : result)
            System.out.print(c);
    }
    public static void dp() {
        for (int i = 1; i < remember.length; i++) {
            for (int j = 1; j < remember[i].length; j++) {
                if(charArray2[i-1]==charArray1[j-1]) {
                    remember[i][j] = remember[i-1][j-1]+1;
                }else {
                    remember[i][j] = Math.max(remember[i-1][j], remember[i][j-1]);
                }
            }
        }
    }
}