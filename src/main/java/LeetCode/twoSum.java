package LeetCode;

import java.util.HashMap;

public class twoSum {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> library = new HashMap<>();
    for (int index = 0; index < nums.length; index++){
      if (library.get(Integer.valueOf(target - nums[index])) != null){
        return new int[]{
            library.get(Integer.valueOf(target - nums[index])),
            index};
      } else {
        library.put(nums[index], index);
      }
    }

    return null;
  }

}
