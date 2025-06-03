public class fourSquare {

    static char[][] charset = {{'A', 'B', 'C', 'D', 'E'}, {'F', 'G', 'H', 'I','J'}, {'K', 'L', 'M', 'N', 'O'}, {'P', 'R', 'S', 'T', 'U'}, {'V', 'W', 'X', 'Y', 'Z'}};

    static char[][] charsetK1 = {{' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}};

    static char[][] charsetK2 = {{' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}};

    static boolean exist(char x, char[][] charset) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (charset[i][j] == x) {
                    return true;
                }
            }
        }
        return false;
    }


    static int location(char x, char[][] charset) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (charset[i][j] == x) {
                    return ((i * 10) + j);
                }
            }
        }
        return -1;
    }

    static void init(String KeyWord, String KeyWord2) {
        KeyWord = KeyWord.toUpperCase();
        KeyWord2 = KeyWord2.toUpperCase();

        int c = 0;
        for (int i = 0; i < KeyWord.length(); i++) {
            if (!exist(KeyWord.charAt(i), charsetK1)) {
                charsetK1[c / 5][c % 5] = KeyWord.charAt(i);
                c++;
            }
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            if (i == 'Q') {
                continue;
            }
            if (!exist(i, charsetK1)) {
                charsetK1[c / 5][c % 5] = i;
                c++;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(charsetK1[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        int c2 = 0;
        for (int i = 0; i < KeyWord2.length(); i++) {
            if (!exist(KeyWord2.charAt(i), charsetK2)) {
                charsetK2[c2 / 5][c2 % 5] = KeyWord2.charAt(i);
                c2++;
            }
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            if (i == 'Q') {
                continue;
            }
            if (!exist(i, charsetK2)) {
                charsetK2[c2 / 5][c2 % 5] = i;
                c2++;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(charsetK2[i][j]);
            }
            System.out.println();
        }

        System.out.println();

    }

    static String encrypt(String M) {
        M = M.toUpperCase();

        String cip = "";

        if (M.length() % 2 == 1)
            M = M + "X";

        for (int i = 0; i < M.length(); i += 2) {
            int L1 = location(M.charAt(i), charset);
            int a1 = L1 / 10;
            int b1 = L1 % 10;

            int L2 = location(M.charAt(i + 1), charset);
            int a2 = L2 / 10;
            int b2 = L2 % 10;


            cip += charsetK1[a1][b2];
            cip += charsetK2[a2][b1];


        }

        return cip;
    }


    static String decrypt(String C) {
        C = C.toUpperCase();

        String plt = "";


        for (int i = 0; i < C.length(); i += 2) {
            int L1 = location(C.charAt(i), charsetK1);
            int a1 = L1 / 10;
            int b1 = L1 % 10;

            int L2 = location(C.charAt(i + 1), charsetK2);
            int a2 = L2 / 10;
            int b2 = L2 % 10;


            plt += charset[a1][b2];
            plt += charset[a2][b1];


        }

        return plt;
    }


}
