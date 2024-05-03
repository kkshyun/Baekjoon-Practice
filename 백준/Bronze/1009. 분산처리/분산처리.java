import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            String[] str = br.readLine().split(" ");

            int a = Integer.parseInt(String.valueOf(str[0].charAt(str[0].length()-1)));
            int b = Integer.parseInt(str[1]);

            result[i] = resultFunc(a,b);
        }
        for (int i = 0; i < num; i++) {
            if(result[i] == 0)
                System.out.println(10);
            else System.out.println(result[i]);
        }
    }
    public static int resultFunc(int a,int b) {
        int result = 10;
        switch(a) {
            case 1 :
                result=1;
                break;
            case 2:
                b = b % 4;
                switch(b) {
                    case 1 :
                        result=2;
                        break;
                    case 2 :
                        result=4;
                        break;
                    case 3 :
                        result=8;
                        break;
                    case 0 :
                        result=6;
                        break;
                }
                break;
            case 3:
                b = b % 4;
                switch(b) {
                    case 1 :
                        result=3;
                        break;
                    case 2 :
                        result=9;
                        break;
                    case 3 :
                        result=7;
                        break;
                    case 0 :
                        result=1;
                        break;
                }
                break;
            case 4 :
                b = b % 2;
                switch(b) {
                    case 1 :
                        result=4;
                        break;
                    case 0 :
                        result=6;
                        break;
                }
                break;
            case 5 :
                result=5;
                break;
            case 6 :
                result=6;
                break;
            case 7:
                b = b % 4;
                switch(b) {
                    case 1 :
                        result=7;
                        break;
                    case 2 :
                        result=9;
                        break;
                    case 3 :
                        result=3;
                        break;
                    case 0 :
                        result=1;
                        break;
                }
                break;
            case 8:
                b = b % 4;
                switch(b) {
                    case 1 :
                        result=8;
                        break;
                    case 2 :
                        result=4;
                        break;
                    case 3 :
                        result=2;
                        break;
                    case 0 :
                        result=6;
                        break;
                }
                break;
            case 9 :
                b = b % 2;
                switch(b) {
                    case 1 :
                        result=9;
                        break;
                    case 0 :
                        result=1;
                        break;
                }
                break;
        }
        return result;
    }
}
