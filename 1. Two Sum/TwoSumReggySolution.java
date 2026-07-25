import java.util.HashMap;

public class TwoSumReggySolution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSumIndexes(nums, target);

        if (result != null) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No valid pair found.");
        }
    }
    public static int[] twoSumIndexes(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index  map
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(array[i], i);
        }
        return null;
    }
}
