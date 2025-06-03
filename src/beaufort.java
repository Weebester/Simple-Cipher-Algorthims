public class beaufort {
    static char[][] charset = new char[26][26];

    static void init() {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                charset[i][j] = (char) ('A' + (i + j) % 26);
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                System.out.print(charset[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();


    }

    static String enc(String M, String K) {
        String cip = "";
        for (int i = 0; i < M.length(); i++) {
            if (M.charAt(i) == ' ') {
                cip += ' ';
            } else {
                int k1 = M.charAt(i) - 'A';
                for (int k2 = 0; k2 < charset[k1].length; k2++) {
                    if (charset[k1][k2] == K.charAt(i % K.length())) {
                        cip += charset[0][k2];
                        break;
                    }
                }

            }
        }
        return cip;
    }

    static String dec(String C, String K) {
        String pt = "";


        for (int i = 0; i < C.length(); i++) {
            if (C.charAt(i) == ' ') {
                pt += ' ';
            } else {
                int k2 = C.charAt(i) - 'A';
                for (int k1 = 0; k1 < charset.length; k1++) {
                    if (charset[k1][k2] == K.charAt(i % K.length())) {
                        pt += charset[k1][0];
                        break;
                    }
                }

            }
        }

        return pt;
    }

}
