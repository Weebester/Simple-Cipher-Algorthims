public class polybius {
    static char[][] charset = {
            {'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'K'},
            {'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U'},
            {'V', 'W', 'X', 'Y', 'Z'}
    };


    static String encrypt(String M) {
        String C = "";

        for (int k = 0; k < M.length(); k++) {
            if (M.charAt(k) == ' ') {
                C += "  ";
            } else if (M.charAt(k) == 'J') {
                C += (1 + "" + 3);
            } else {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (M.charAt(k) == charset[i][j]) {
                            C += (i + "" + j);
                        }
                    }
                }
            }


        }
        return C;
    }

    static String decrypt(String C) {
        String M = "";
        for (int k = 0; k < C.length() ; k += 2) {
            if (C.charAt(k) == ' ') {
                M += " ";
            } else {
                int temp = Integer.parseInt(C.substring(k, (k + 2)));
                int i = temp / 10;
                int j = temp % 10;
                M += charset[i][j];
            }
        }
        return M;
    }
}