import java.util.HashMap;
import java.util.Map;

public class q3 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int X = 9;

        int[] resultadoSimples = simple(nums, X);
        int[] resultadoMelhorado = melhorada(nums, X);
        int[] resultadoMelhorCaso = melhorCaso(nums, X);

        if (resultadoSimples != null) {
            System.out.println("Solução Simples: [" + resultadoSimples[0] + ", " + resultadoSimples[1] + "]");
        } else {
            System.out.println("Solução Simples: Nenhum par encontrado");
        }

        if (resultadoMelhorado != null) {
            System.out.println("Solução Melhorada: [" + resultadoMelhorado[0] + ", " + resultadoMelhorado[1] + "]");
        } else {
            System.out.println("Solução Melhorada: Nenhum par encontrado");
        }

        if (resultadoMelhorCaso != null) {
            System.out.println("Solução Melhor Caso: [" + resultadoMelhorCaso[0] + ", " + resultadoMelhorCaso[1] + "]");
        } else {
            System.out.println("Solução Melhor Caso: Nenhum par encontrado");
        }
    }

    public static int[] simple(int[] nums, int X) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == X) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] melhorada(int[] nums, int X) {
        Map<Integer, Integer> numDict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = X - nums[i];
            if (numDict.containsKey(complement)) {
                return new int[]{numDict.get(complement), i};
            }
            numDict.put(nums[i], i);
        }
        return null;
    }

    public static int[] melhorCaso(int[] nums, int X) {
        Map<Integer, Integer> numDict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = X - nums[i];
            if (numDict.containsKey(complement)) {
                return new int[]{numDict.get(complement), i};
            }
            numDict.put(nums[i], i);
        }
        return null;
    }
}