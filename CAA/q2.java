public class q2 {

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] B = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        int[][] resultado = multiDeM(A, B);

        printMatriz(resultado);
    }

    public static int[][] multiDeM(int[][] A, int[][] B) {
        int n = A.length;

        if (n == 1) {
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        int[][] A11 = divideMatriz(A, 0, 0, n / 3);
        int[][] A12 = divideMatriz(A, 0, n / 3, n / 3);
        int[][] A13 = divideMatriz(A, 0, 2 * (n / 3), n / 3);
        int[][] A21 = divideMatriz(A, n / 3, 0, n / 3);
        int[][] A22 = divideMatriz(A, n / 3, n / 3, n / 3);
        int[][] A23 = divideMatriz(A, n / 3, 2 * (n / 3), n / 3);
        int[][] A31 = divideMatriz(A, 2 * (n / 3), 0, n / 3);
        int[][] A32 = divideMatriz(A, 2 * (n / 3), n / 3, n / 3);
        int[][] A33 = divideMatriz(A, 2 * (n / 3), 2 * (n / 3), n / 3);

        int[][] B11 = divideMatriz(B, 0, 0, n / 3);
        int[][] B12 = divideMatriz(B, 0, n / 3, n / 3);
        int[][] B13 = divideMatriz(B, 0, 2 * (n / 3), n / 3);
        int[][] B21 = divideMatriz(B, n / 3, 0, n / 3);
        int[][] B22 = divideMatriz(B, n / 3, n / 3, n / 3);
        int[][] B23 = divideMatriz(B, n / 3, 2 * (n / 3), n / 3);
        int[][] B31 = divideMatriz(B, 2 * (n / 3), 0, n / 3);
        int[][] B32 = divideMatriz(B, 2 * (n / 3), n / 3, n / 3);
        int[][] B33 = divideMatriz(B, 2 * (n / 3), 2 * (n / 3), n / 3);

        int[][] P1 = multiDeM(A11, subtractMatrizes(B12, B22));
        int[][] P2 = multiDeM(addMatrizes(A11, A12), B22);
        int[][] P3 = multiDeM(addMatrizes(A21, A22), B11);
        int[][] P4 = multiDeM(A22, subtractMatrizes(B21, B11));
        int[][] P5 = multiDeM(addMatrizes(A11, A33), addMatrizes(B11, B33));
        int[][] P6 = multiDeM(subtractMatrizes(A12, A22), addMatrizes(B21, B22));
        int[][] P7 = multiDeM(subtractMatrizes(A13, A23), addMatrizes(B32, B33));

        int[][] C11 = addMatrizes(addMatrizes(P5, P4), subtractMatrizes(P6, P2));
        int[][] C12 = addMatrizes(P1, P2);
        int[][] C13 = addMatrizes(P3, P4);
        int[][] C21 = subtractMatrizes(subtractMatrizes(addMatrizes(P5, P1), P3), P7);
        int[][] C22 = addMatrizes(P3, P4);
        int[][] C23 = addMatrizes(addMatrizes(P5, P1), subtractMatrizes(P2, P6));
        int[][] C31 = addMatrizes(P3, P7);
        int         [][] C32 = subtractMatrizes(subtractMatrizes(addMatrizes(P4, P5), P6), P2);
        int[][] C33 = addMatrizes(addMatrizes(P1, P5), subtractMatrizes(P3, P7));

        int[][] C = new int[n][n];

        combineMatrizes(C, C11, 0, 0);
        combineMatrizes(C, C12, 0, n / 3);
        combineMatrizes(C, C13, 0, 2 * (n / 3));
        combineMatrizes(C, C21, n / 3, 0);
        combineMatrizes(C, C22, n / 3, n / 3);
        combineMatrizes(C, C23, n / 3, 2 * (n / 3));
        combineMatrizes(C, C31, 2 * (n / 3), 0);
        combineMatrizes(C, C32, 2 * (n / 3), n / 3);
        combineMatrizes(C, C33, 2 * (n / 3), 2 * (n / 3));

        return C;
    }

    public static int[][] divideMatriz(int[][] matriz, int startRow, int startCol, int tamanho) {
        int[][] resultado = new int[tamanho][tamanho];
        for (int i = 0; i < tamanho; i++) {
            System.arraycopy(matriz[startRow + i], startCol, resultado[i], 0, tamanho);
        }
        return resultado;
    }

    public static int[][] addMatrizes(int[][] A, int[][] B) {
        int[][] resultado = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                resultado[i][j] = A[i][j] + B[i][j];
            }
        }
        return resultado;
    }

    public static int[][] subtractMatrizes(int[][] A, int[][] B) {
        int[][] resultado = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                resultado[i][j] = A[i][j] - B[i][j];
            }
        }
        return resultado;
    }

    public static void combineMatrizes(int[][] matriz, int[][] subMatriz, int startRow, int startCol) {
        for (int i = 0; i < subMatriz.length; i++) {
            System.arraycopy(subMatriz[i], 0, matriz[startRow + i], startCol, subMatriz.length);
        }
    }

    public static void printMatriz(int[][] matriz) {
        for (int[] row : matriz) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}