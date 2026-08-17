package LucySolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num_map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (num_map.containsKey(complement)) {
                return new int[] { num_map.get(complement), i };
            }
            num_map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));  // expected: [0, 1]
    }
}