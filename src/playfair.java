public class playfair {

    static char[][] charset = {
            {' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' '}};

    static boolean exist(char x) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (charset[i][j] == x) {
                    return true;
                }
            }
        }
        return false;
    }

    static void init(String KeyWord) {
        KeyWord = KeyWord.toUpperCase();

        int c = 0;
        for (int i = 0; i < KeyWord.length(); i++) {
            if (!exist(KeyWord.charAt(i))) {
                charset[c / 5][c % 5] = KeyWord.charAt(i);
                c++;
            }
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            if (i == 'Q') {
                continue;
            }
            if (!exist(i)) {
                charset[c / 5][c % 5] = i;
                c++;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(charset[i][j]);
            }
            System.out.println();
        }

    }

    static int location(char x) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (charset[i][j] == x) {
                    return ((i * 10) + j);
                }
            }
        }
        return -1;
    }


    static String encrypt(String M) {
        M = M.toUpperCase();

        String cip = "";

        for (int i = 0; i < M.length(); i += 2) {
            if ((i) == M.length() - 1) {
                M += 'X';
            } else if (M.charAt(i) == M.charAt(i + 1)) {
                M = M.substring(0, i + 1) + 'X' + M.substring(i + 1);
            }
        }
        for (int i = 0; i < M.length(); i += 2) {
            int L1 = location(M.charAt(i));
            int a1 = L1 / 10;
            int b1 = L1 % 10;

            int L2 = location(M.charAt(i+1));
            int a2 = L2 / 10;
            int b2 = L2 % 10;

            if (a1==a2){
                cip+=charset[a1][(b1+1)%5];
                cip+=charset[a2][(b2+1)%5];
            } else if (b1==b2) {
                cip+=charset[(a1+1)%5][b1];
                cip+=charset[(a2+1)%5][b2];
            } else {
                cip+=charset[a1][b2];
                cip+=charset[a2][b1];
            }



        }

        return cip;
    }

    static String decrypt(String C) {
        C = C.toUpperCase();

        String plt = "";

        for (int i = 0; i < C.length(); i += 2) {
            if ((i) == C.length() - 1) {
                C += 'X';
            } else if (C.charAt(i) == C.charAt(i + 1)) {
                C = C.substring(0, i + 1) + 'X' + C.substring(i + 1);
            }
        }
        for (int i = 0; i < C.length(); i += 2) {
            int L1 = location(C.charAt(i));
            int a1 = L1 / 10;
            int b1 = L1 % 10;

            int L2 = location(C.charAt(i+1));
            int a2 = L2 / 10;
            int b2 = L2 % 10;

            if (a1==a2){
                plt+=charset[a1][(b1-1+5)%5];
                plt+=charset[a2][(b2-1+5)%5];
            } else if (b1==b2) {
                plt+=charset[(a1-1+5)%5][b1];
                plt+=charset[(a2-1+5)%5][b2];
            } else {
                plt+=charset[a1][b2];
                plt+=charset[a2][b1];
            }



        }

        return plt;
    }

}
