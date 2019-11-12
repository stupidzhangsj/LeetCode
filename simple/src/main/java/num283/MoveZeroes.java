package num283;

/**
 * @author :zhangshengjun
 * @create 2019-10-25 8:44
 **/
public class MoveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 1. 必须在原数组上操作，不能拷贝额外的数组。
     * 2. 尽量减少操作次数。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 0, 8, 12};
        long start = System.currentTimeMillis();
        moveZeroes2(nums);
        System.out.println(System.currentTimeMillis() - start);

    }

    /**
     * [0...firstNonZero)的元素均为非 0 元素，最后将剩余的全部填充为 0；
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {

        // 第一个0 出现的位置
        int firstNonZero = 0;
        // 遍历到第i个元素后,保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[firstNonZero++] = nums[i];
            }
        }
        // 将nums剩余的位置放置为0
        for (int i = firstNonZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 遇到非 0 的数字，就和第一个 0 交换位置
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        // 当前数组中第一个0 出现的位置
        int firstNonZero = 0;

        // 遍历到第i个元素后,保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, firstNonZero++, i);
            }
        }
    }

    public static void swap(int[] nums, int before, int after) {
        int temp = nums[after];
        nums[after] = nums[before];
        nums[before] = temp;
    }

}
