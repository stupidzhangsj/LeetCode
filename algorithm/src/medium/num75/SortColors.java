package medium.num75;

/**
 * @author :zhangshengjun
 * @create 2019-10-25 19:29
 **/
public class SortColors {
    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 注意: 不能使用代码库中的排序函数来解决这道题。
     * <p>
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, 0, 1, 2, 1, 1, 0, 2, 1, 1, 1, 2, 2, 0, 0, 0};
        //nums = new int[]{2,0,1};
        sortColors2(nums);
        System.out.println(nums);
    }

    /**
     * 思路：
     * 三个指针排序，左边放置最小的，右边放置最大的；
     * 遍历数组，遇到2 就放置最右边，遇到0 就放到最左边，这个位置就需要记录 左边下一次需要放置 0 的位置，或者理解成当前 0 应该放置在哪里；
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {

        //定义指针
        int leftZero = 0;
        int rightTwo = nums.length - 1;
        for (int i = 0; i <= rightTwo; ) {
            int num = nums[i];
            if (num == 0) {
                swap(nums, leftZero++, i++);
            } else if (num == 1) {
                i++;
            } else if (num == 2) {
                swap(nums, i, rightTwo--);
            }
        }
    }

    /**
     * 解法2 将小的放在左边
     *
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        //定义指针
        //zero（0 的下标）  one (1 的下标)
        int zero = -1;
        int one = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 2) {
                swap(nums, i, ++one);
                if (nums[one] < 1) {
                    swap(nums, ++zero, one);
                }
            }

        }
    }

    private static void swap(int[] nums, int before, int after) {
        int temp = nums[after];
        nums[after] = nums[before];
        nums[before] = temp;
    }


}
