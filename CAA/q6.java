import java.util.ArrayList;
import java.util.List;

public class q6 {

    public static void main(String[] args) {
        String sequencia = "ACGTGTCAAAATCG";
        ResultadoPalindromo resultado = palindromo(sequencia);
        System.out.println("Subsequência palíndroma: " + resultado.getSubsequencia());
        System.out.println("Tamanho: " + resultado.getTamanho());
    }

    public static class ResultadoPalindromo {
        private final String subsequencia;
        private final int tamanho;

        public ResultadoPalindromo(String subsequencia, int tamanho) {
            this.subsequencia = subsequencia;
            this.tamanho = tamanho;
        }

        public String getSubsequencia() {
            return subsequencia;
        }

        public int getTamanho() {
            return tamanho;
        }
    }

    public static ResultadoPalindromo palindromo(String S) {
        int n = S.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (S.charAt(i) == S.charAt(j) && cl == 2) {
                    dp[i][j] = 2;
                } else if (S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        List<Character> result = new ArrayList<>();
        int i = 0, j = n - 1;
        while (i < j) {
            if (S.charAt(i) == S.charAt(j)) {
                result.add(S.charAt(i));
                i++;
                j--;
            } else if (dp[i][j - 1] > dp[i + 1][j]) {
                j--;
            } else {
                i++;
            }
        }

        if (i == j) {
            result.add(S.charAt(i));
        }

        StringBuilder resultadoStr = new StringBuilder();
        for (char ch : result) {
            resultadoStr.append(ch);
        }

        return new ResultadoPalindromo(resultadoStr.toString(), resultadoStr.length());
    }
}