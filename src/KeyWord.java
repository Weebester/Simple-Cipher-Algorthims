import java.util.ArrayList;

public class KeyWord {
    static ArrayList<Character> ch1 = new ArrayList<>();
    static ArrayList<Character> ch2 = new ArrayList<>();
    static String keyword = "dinosaur";

    static void init() {
        for (char i = 'A'; i < 'Z'; i++) {
            ch1.add(i);
        }
        ch1.add(' ');

        for (int i = 0; i < keyword.length(); i++) {
            if (!ch2.contains(keyword.charAt(i))) {
                ch2.add(keyword.charAt(i));
            }
        }

        for (int i = 0; i < 26; i++) {
            if (!ch2.contains(ch1.get(i))) {
                ch2.add(ch1.get(i));
            }
        }

    }

    static String encrypt(String M) {
        String C = "";

        for (int i = 0; i < M.length(); i++) {
            C += ch2.get(ch1.indexOf(M.charAt(i)));
        }

        return C;
    }

    static String decrypt(String C) {
        String M = "";

        for (int i = 0; i < C.length(); i++) {
            M += ch1.get(ch2.indexOf(C.charAt(i)));
        }

        return M;
    }
}
