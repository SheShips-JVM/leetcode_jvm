import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class SheebaSolution {

    public int[] twoSum(int[] nums, int target){

        //stores each number and its index
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            //find number needed to reach target
            int complement = target - nums[i];

            //check if complement has already been seen
            Integer complementIndex = numToIndex.get(complement);

            if (complementIndex != null){
                return new int[]{complementIndex, i};
            }
            //store current number and its index
            numToIndex.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution found");
    }


    //testing the algorithm
    public static void main(String[] args){
        SheebaSolution solution = new SheebaSolution();


        //print their indexes
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] results = solution.twoSum(new int[]{3, 6, 4, 12}, 18);
//        int[] takeaway = solution.twoSum(new int[]{3, 6, 4, 2}, 13);

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(results));
//        System.out.println(Arrays.toString(takeaway));
    }
}
