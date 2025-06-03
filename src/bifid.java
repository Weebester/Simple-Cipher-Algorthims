import java.util.Arrays;

public class bifid {
    static char[][] charset = {
            {'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'K'},
            {'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U'},
            {'V', 'W', 'X', 'Y', 'Z'}
    };


    static String encrypt(String M) {
        String C = "";
        int[] T = new int[M.length() * 2];


        for (int k = 0; k < M.length(); k++) {
            if (M.charAt(k) == 'J') {
                T[k] = 1;
                T[M.length() + k] = 3;
            } else {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (M.charAt(k) == charset[i][j]) {
                            System.out.println(M.charAt(k) + ":" + (i + 1) + "" + (j + 1) + ",");
                            T[k] = i;
                            T[M.length() + k] = j;
                        }
                    }
                }
            }
        }


        for (int k = 0; k < T.length; k += 2) {
            C += charset[T[k]][T[k + 1]];
        }
        return C;
    }

    static String decrypt(String C) {
        String M = "";
        int[] T = new int[C.length()*2];

        for (int k = 0; k < C.length(); k++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (C.charAt(k) == charset[i][j]) {
                        T[k*2] = i;
                        T[k*2+1] = j;
                    }
                }
            }
        }

        for (int k = 0; k < C.length(); k++) {
            M += charset[T[k]][T[C.length()+ k]];
        }


        return M;
    }
}