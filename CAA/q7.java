import java.util.Arrays;

public class q7 {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] saida = quadradoord(nums);
        System.out.println(Arrays.toString(saida));
    }

    public static int[] quadradoord(int[] nums) {
        int n = nums.length;
        int[] resultado = new int[n];

        int esquerda = 0, direita = n - 1;
        int indice = n - 1;

        while (esquerda <= direita) {
            int quadradoEsquerdo = nums[esquerda] * nums[esquerda];
            int quadradoDireito = nums[direita] * nums[direita];

            if (quadradoEsquerdo > quadradoDireito) {
                resultado[indice] = quadradoEsquerdo;
                esquerda++;
            } else {
                resultado[indice] = quadradoDireito;
                direita--;
            }
            indice--;
        }
        return resultado;
    }
}