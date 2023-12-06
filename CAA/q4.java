import java.util.HashMap;
import java.util.Map;

public class q4 {

    public static void main(String[] args) {
        int[] nums1 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int saida1 = majorityElement(nums1);
        System.out.println(saida1);

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int saida2 = majorityElement(nums2);
        System.out.println(saida2);
    }

    public static int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}