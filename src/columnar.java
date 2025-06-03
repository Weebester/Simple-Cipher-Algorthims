public class columnar {


    static String encrypt(String plain) {
        char[][] table;

        int a = plain.length();
        int l;
        if (a % 4 == 0) {
            l = a / 4;
        } else {
            l = (a / 4) + 1;
        }
        table = new char[l][4];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i * 4 + j) < plain.length()) {
                    table[i][j] = plain.charAt((i * 4 + j));
                } else {
                    table[i][j] = 'X';
                }
            }
        }

        String C = "";
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < l; i++) {
                C += table[i][j];
            }
        }
        return C;
    }

    static String decrypt(String cipher) {
        char[][] table;

        int a = cipher.length();
        int l;
        l = a / 4;

        table = new char[l][4];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i+ j*l)<cipher.length())
                table[i][j] = cipher.charAt((i+ j*l));
            }
        }

        String P = "";
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(table[i][j] + " ");
                P+=table[i][j];
            }
            System.out.println();
        }

        return P;
    }
}
