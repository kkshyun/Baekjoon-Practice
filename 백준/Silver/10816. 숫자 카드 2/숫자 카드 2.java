import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> keySet;
    static HashMap<Integer,Integer> mapN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arrN = new int[n];
        mapN = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(s[i]);
            if(mapN.containsKey(arrN[i])) {
                Integer newValue = mapN.get(arrN[i])+1;
                mapN.replace(arrN[i],newValue);
            }
            else{
                mapN.put(arrN[i],1);
            }
        }
        keySet = new ArrayList<>(mapN.keySet());
        Collections.sort(keySet);

//        for (Integer key : keySet) {
//            System.out.print("Key : " + key);
//            System.out.println(", Val : " + mapN.get(key));
//        }

        int m = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        int[] arrM = new int[m];
        int result[] = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(s[i]);
            result[i] = binarySearch(0,keySet.size()-1, arrM[i]);
        }

        for (int i = 0; i < m; i++) {
            bw.write(result[i]+" ");
        }
        bw.flush();
        bw.close();
    }
    // 반복문
    public static int binarySearch(int low, int high, int find) {
        while(low <= high) {
            int mid = (low + high) / 2;
            int key = keySet.get(mid);

            if(find < key)
                high = mid - 1;
            else if(find > key)
                low = mid + 1;
            else if(find == key)
                return mapN.get(key);
        }
        return 0;
    }
}
