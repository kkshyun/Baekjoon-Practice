import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int rowk, colk, rowr, colr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        rowk = s[0].charAt(0) - 'A' + 1; // 1 ~ 8
        colk = s[0].charAt(1) - '0'; // 1 ~ 8
        rowr = s[1].charAt(0) - 'A' + 1 ;
        colr = s[1].charAt(1) - '0';
        int N = Integer.parseInt(s[2]);
        for (int i = 0; i < N; i++) {
            move(br.readLine());
        }

        System.out.println((char)('A'+rowk-1)+""+colk);
        System.out.println((char)('A'+rowr-1)+""+colr);

    }
    public static void move(String m) {
        switch(m) {
            case "R" :
                rowk += 1;
                if(rowk > 8) {
                    rowk -= 1;
                    break;
                }
                if(rowk == rowr & colk == colr) {
                    rowr += 1;
                }
                if(rowr > 8) {
                    rowk -= 1;
                    rowr -= 1;
                }
                break;

            case "L" :
                rowk -= 1;
                if(rowk < 1) {
                    rowk += 1;
                    break;
                }
                if(rowk == rowr & colk == colr) {
                    rowr -= 1;
                }
                if(rowr < 1) {
                    rowk += 1;
                    rowr += 1;
                }
                break;

            case "B" :
                colk -= 1;
                if(colk < 1) {
                    colk += 1;
                    break;
                }
                if(rowk == rowr & colk == colr) {
                    colr -= 1;
                }
                if(colr < 1) {
                    colk += 1;
                    colr += 1;
                }
                break;

            case "T" :
                colk += 1;
                if(colk > 8) {
                    colk -= 1;
                    break;
                }
                if(rowk == rowr & colk == colr) {
                    colr += 1;
                }
                if(colr > 8) {
                    colk -= 1;
                    colr -= 1;
                }
                break;

            case "RT" :
                rowk += 1;
                colk += 1;
                if(colk > 8 || rowk > 8) {
                    colk -= 1;
                    rowk -= 1;
                    break;
                }
                if(rowk == rowr & colk == colr) {
                    rowr += 1;
                    colr += 1;
                }
                if(colr > 8 || rowr > 8) {
                    colk -= 1;
                    rowk -= 1;
                    rowr -= 1;
                    colr -= 1;
                }
                break;

            case "LT" :
                rowk -= 1;
                colk += 1;
                if(colk > 8 || rowk < 1) {
                    colk -= 1;
                    rowk += 1;
                    break;
                }
                if(rowk == rowr & colk == colr) {
                    colr += 1;
                    rowr -= 1;
                }
                if(rowr < 1 || colr > 8) {
                    colk -= 1;
                    rowk += 1;
                    colr -= 1;
                    rowr += 1;
                }
                break;

            case "RB" :
                rowk += 1;
                colk -= 1;
                if(rowk > 8 || colk < 1) {
                    rowk -= 1;
                    colk += 1;
                    break;
                }
                if(rowk == rowr & colk == colr) {
                    rowr += 1;
                    colr -= 1;
                }
                if(rowr > 8 || colr < 1) {
                    rowk -= 1;
                    colk += 1;
                    rowr -= 1;
                    colr += 1;
                }
                break;

            case "LB" :
                rowk -= 1;
                colk -= 1;
                if(rowk < 1 || colk < 1) {
                    rowk += 1;
                    colk += 1;
                    break;
                }
                if(rowk == rowr & colk == colr) {
                    rowr -= 1;
                    colr -= 1;
                }
                if(rowr < 1 || colr < 1) {
                    rowk += 1;
                    colk += 1;
                    rowr += 1;
                    colr += 1;
                }
                break;

        }
    }
}