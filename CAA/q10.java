public class q10 {

    public static void main(String[] args) {
        int[] numsExemplo1 = {1, 3, 5, 6};
        int alvoExemplo1 = 5;
        int resultadoExemplo1 = buscaInsercao(numsExemplo1, alvoExemplo1);
        System.out.println(resultadoExemplo1);

        int[] numsExemplo2 = {1, 3, 5, 6};
        int alvoExemplo2 = 2;
        int resultadoExemplo2 = buscaInsercao(numsExemplo2, alvoExemplo2);
        System.out.println(resultadoExemplo2);
    }

    public static int buscaInsercao(int[] nums, int alvo) {
        int esquerda = 0;
        int direita = nums.length - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;

            if (nums[meio] == alvo) {
                return meio;
            } else if (nums[meio] < alvo) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return esquerda;
    }
}