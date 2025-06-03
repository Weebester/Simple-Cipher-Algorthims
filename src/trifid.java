public class trifid {
    static char[][][] charset = {{{'A', 'D', 'G'}, {'B', 'E', 'H'}, {'C', 'F', 'I'},

    }, {{'J', 'M', 'P'}, {'K', 'N', 'Q'}, {'L', 'O', 'R'},

    }, {{'S', 'V', 'Y'}, {'T', 'W', 'Z'}, {'U', 'X', ' '},

    },};


    static String encrypt(String M) {
        String C = "";
        int[] T = new int[M.length() * 3];

        for (int k = 0; k < M.length(); k++) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    for (int z = 0; z < 3; z++) {
                        if (M.charAt(k) == charset[x][y][z]) {
                            System.out.println(M.charAt(k) + ":" + (x + 1) + "" + (y + 1) + "" + (z + 1) + ",");
                            T[k] = x;
                            T[M.length() + k] = y;
                            T[M.length() * 2 + k] = z;
                        }
                    }
                }
            }
        }

        for (int k = 0; k < T.length; k += 3) {
            C += charset[T[k]][T[k + 1]][T[k + 2]];
        }

        return C;
    }

    static String decrypt(String C) {
        String M = "";

        int[] T = new int[C.length() * 3];

        for (int k = 0; k < C.length(); k++) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    for (int z = 0; z < 3; z++) {
                        if (C.charAt(k) == charset[x][y][z]) {
                            T[k * 3] = x;
                            T[k * 3 + 1] = y;
                            T[k * 3 + 2] = z;
                        }
                    }
                }
            }
        }

        for (int k = 0; k < C.length(); k++) {
            M += charset[T[k]][T[C.length() + k]][T[C.length()  * 2+ k]];
        }


        return M;
    }
}