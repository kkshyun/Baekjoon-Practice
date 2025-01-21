import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static boolean[] arr, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        arr = new boolean[10000];
        Arrays.fill(arr,true);
        arr[0] = false;
        arr[1] = false;
        for (int j = 2; j <= Math.sqrt(arr.length-1); j++) {
            if(!arr[j])
                continue;
            for (int k = j*2; k <= arr.length-1; k+=j) {
                arr[k] = false;
            }
        }

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            int originalNum = Integer.parseInt(s[0]);
            int changeNum = Integer.parseInt(s[1]);
            visited = new boolean[10000];
            int result = bfs(originalNum, changeNum, 0);
            if(result==-1)
                bw.write("Impossible\n");
            else
                bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }



    public static int bfs(int num, int target, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{num, count});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(visited[poll[0]])
                continue;
            if(poll[0]==target) {
                return poll[1];
            }
            visited[poll[0]] = true;

//            char[] charArray = String.valueOf(poll[0]).toCharArray();
//            for (int i = 0; i < 4; i++) {
//                char originalDigit = charArray[i];
//                for (char newDigit = '0'; newDigit <= '9'; newDigit++) {
//                    charArray[i] = newDigit;
//                    int newNumber = Integer.parseInt(new String(charArray));
//                    if(newNumber>=1000&&newNumber<10000&&arr[newNumber]&&!visited[newNumber])
//                        queue.add(new int[]{newNumber,poll[1]+1});
//                }
//                charArray[i] = originalDigit;
//            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    String temp = String.valueOf(poll[0]);
                    int changeNum = 0;
                    for (int k = 0; k < 4; k++)
                        if(k!=i)
                            changeNum += (temp.charAt(k)-'0')*Math.pow(10,3-k);
                    changeNum += j*Math.pow(10,3-i);
                    if(changeNum>=1000&&changeNum<10000&&arr[changeNum]&&!visited[changeNum])
                        queue.add(new int[]{changeNum,poll[1]+1});
                }
            }
        }
        return -1;

    }
}