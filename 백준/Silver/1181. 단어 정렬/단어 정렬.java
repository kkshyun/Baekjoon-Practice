import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }
        String[] arr = new String[hashSet.size()];
        int i = 0;
        for(String str:hashSet) {
            arr[i] = str;
            i++;
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                else
                    return o1.length() - o2.length();
            }
        });
        for (int j = 0; j < arr.length; j++) {
            bw.write(arr[j]+"\n");
        }
        bw.flush();
        bw.close();
    }
}