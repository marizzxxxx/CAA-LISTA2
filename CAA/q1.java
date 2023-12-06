public class q1 {

    public static void main(String[] args) {
        int[] S = {1, 3, 2, 5, 4};
        int piv = 3;
        int p = 0;
        int r = S.length - 1;

        System.out.println("Antes da decomposição:");
        printArray(S);

        int[] result = decomposicao(S, piv, p, r);
        int q1 = result[0];
        int q2 = result[1];

        System.out.println("Depois da decomposição:");
        printArray(S);
    }

    public static int[] decomposicao(int[] S, int piv, int p, int r) {
        if (p == r) {
            return new int[]{p, p};
        }

        if (p + 1 == r) {
            if (S[p] < piv) {
                return new int[]{p, p + 1};
            } else {
                return new int[]{p + 1, p + 1};
            }
        }

        int q1 = p;
        int q2 = r;

        for (int i = p + 1; i < r; i++) {
            if (S[i] < piv) {
                int temp = S[i];
                S[i] = S[q1];
                S[q1] = temp;
                q1++;
            }
        }

        if (S[r] > piv) {
            int temp = S[r];
            S[r] = S[q2];
            S[q2] = temp;
            q2--;
        }

        return new int[]{q1, q2};
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}