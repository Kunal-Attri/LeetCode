package leetcode;

public class HouseRobber {
	public int rob(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        }
        int prev = nums[0];
        int prev2 = 0;
        int temp;
        for (int i = 1; i < l; i++) {
            temp = prev;
            prev = Math.max(prev2 + nums[i], prev);
            prev2 = temp;
        }
        return prev;
    }
}
