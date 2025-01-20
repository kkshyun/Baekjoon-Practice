import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<String>[] list;
    static String[] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        int length = s.length;
        list = new ArrayList[K+1];
        for (int i = 0; i <= K; i++) {
            list[i] = new ArrayList<>();
        }
        recursion(0,length-1, K);
        for (int i = K; i >= 1; i--) {
            for(String num : list[i])
                System.out.print(num+" ");
            System.out.println();
        }
    }

    public static void recursion(int start, int end, int depth) {
        if(depth<=0)
            return;
        int length = (start+end)/2;
        list[depth].add(s[length]);
        recursion(start,length-1,depth-1);
        recursion(length+1,end,depth-1);
    }
}