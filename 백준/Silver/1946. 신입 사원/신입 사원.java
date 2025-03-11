import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static class Person{
        int paper;
        int interview;

        public Person(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Person[] people =  new Person[N];
            for (int j = 0; j < N; j++) {
                String[] s = br.readLine().split(" ");
                people[j] = new Person(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
            }
            Arrays.sort(people,((o1, o2) -> Integer.compare(o1.paper,o2.paper)));
            int count = 1;
            int min = people[0].interview;
            for (int j = 1; j < people.length; j++) {
                if (people[j].interview<min) {
                    count++;
                    min = people[j].interview;
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
    }
}