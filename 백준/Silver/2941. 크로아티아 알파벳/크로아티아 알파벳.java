import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;
        int i = 0;

        while (i < str.length()) {
            if (i + 2 < str.length() &&
                str.charAt(i) == 'd' &&
                str.charAt(i + 1) == 'z' &&
                str.charAt(i + 2) == '=') {
                i += 3;
            } else if (i + 1 < str.length() &&
                    ((str.charAt(i) == 'c' && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')) ||
                     (str.charAt(i) == 'd' && str.charAt(i + 1) == '-') ||
                     (str.charAt(i) == 'l' && str.charAt(i + 1) == 'j') ||
                     (str.charAt(i) == 'n' && str.charAt(i + 1) == 'j') ||
                     (str.charAt(i) == 's' && str.charAt(i + 1) == '=') ||
                     (str.charAt(i) == 'z' && str.charAt(i + 1) == '='))) {
                i += 2;
            } else {
                i += 1;
            }
            count++;
        }

        System.out.print(count);
    }
}