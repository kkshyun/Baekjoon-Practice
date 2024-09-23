import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Element[] elements = new Element[n];

        for (int i = 0; i < n; i++) {
            elements[i] = new Element(Integer.parseInt(br.readLine()),i);
        }
        Arrays.sort(elements);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int move = elements[i].originalIndex - i;
            if(max < move)
                max = move;
        }
        System.out.println(max+1);
    }
}

class Element implements Comparable<Element> {
    int value;
    int originalIndex;

    public Element(int value, int originalIndex) {
        this.value = value;
        this.originalIndex = originalIndex;
    }

    @Override
    public int compareTo(Element o) {
        return Integer.compare(this.value, o.value);
    }
}
