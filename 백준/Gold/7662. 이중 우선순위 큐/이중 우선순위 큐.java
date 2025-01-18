import java.io.*;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 오름차순
            TreeMap<Integer,Integer> treeMap = new TreeMap<>((o1,o2)->Integer.compare(o1,o2));
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                String[] s = br.readLine().split(" ");
                if(s[0].equals("I")) {
                    treeMap.put(Integer.parseInt(s[1]),treeMap.getOrDefault(Integer.parseInt(s[1]),0)+1);
                }
                else{
                    if(treeMap.isEmpty())
                        continue;
                    if(s[1].equals("1"))
                    {
                        Integer integer = treeMap.lastKey();
                        if(treeMap.get(integer)==1)
                            treeMap.remove(integer);
                        else
                            treeMap.put(integer,treeMap.get(integer)-1);
                    }
                    else{
                        Integer integer = treeMap.firstKey();
                        if(treeMap.get(integer)==1)
                            treeMap.remove(integer);
                        else
                            treeMap.put(integer,treeMap.get(integer)-1);
                    }
                }
            }

            if(treeMap.isEmpty())
                bw.write("EMPTY\n");
            else
            {
                bw.write(treeMap.lastKey()+" "+ treeMap.firstKey()+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}