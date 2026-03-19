import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        StringTokenizer st;
        for (int i = 0; i < 5 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5 ; j++ ) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean check = false;
        for (int i = 0; i < 5 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5 ; j++ ) {
                checkWhere(Integer.parseInt(st.nextToken()));
                if(checkBingo()>=3) {
                    System.out.print(i*5 + j + 1);
                    check = true;
                    break;
                }
            }
            if(check)
                break;
        }
    }

    static void checkWhere(int num) {
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5 ; j++ ) {
                if(arr[i][j] == num) {
                    arr[i][j] = 0;
                    return;
                }
            }
        } 
    }

    static int checkBingo() {
        int count = 0;
        boolean check = true;
        
        for (int i = 0; i < 5 ; i++) {
            check = true;
            for (int j = 0; j < 5 ; j++ ) {
                if(arr[i][j] != 0) {
                    check = false;
                    break;
                }
            }
            if(check)
                count++;
        }  
        
        for (int i = 0; i < 5 ; i++) {
            check = true;
            for (int j = 0; j < 5 ; j++ ) {
                if(arr[j][i] != 0) {
                    check = false;
                    break;
                }
            }
            if(check)
                count++;
        }
        
        check = true;
        for (int i = 0; i < 5 ; i++) {
            if(arr[i][i] != 0) {
                check = false;
                break;
            }
        }     
        if(check)
            count++;
        
        check = true;
        for (int i = 0; i < 5 ; i++) {
            if(arr[i][4-i] != 0) {
                check = false;
                break;
            }
        }     
        if(check)
            count++;
        
        return count;
    }
}