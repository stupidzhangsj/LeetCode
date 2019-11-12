package num300;

import java.util.Arrays;

/**
 * @author :zhangshengjun
 * @create 2019-10-29 13:57
 **/
public class lengthOfLIS {
    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     */

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        lengthOfLIS2(nums);
    }

    /**
     * 用一个辅助数组，记录当前位置的最大序列的值
     *
     * @param nums
     * @return
     */
    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * dp 中存最小的，遍历原数组，判断这个数应该在 dp 数组的位置。如果当前位置超过历史最大值，则最长度+1
     *
     * @param nums
     * @return
     */
    private static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, max, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == max) {
                max++;
            }
        }
        return max;

    }
}
