import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int age = Integer.parseInt(s[0]);
            String name = s[1];
            list.add(new Person(age,name));
        }
        Collections.sort(list, (o1,o2)->o1.age - o2.age);
        for(Person person : list) {
            bw.write(person.age+" "+person.name+"\n");
        }
        bw.flush();
        bw.close();
    }
}