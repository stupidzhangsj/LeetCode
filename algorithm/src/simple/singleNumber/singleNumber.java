package simple.singleNumber;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class singleNumber {
    public static void main(String[] args) {
        int i = singleNumber2(new int[]{1,3,6,2, 1,3, 2});
        System.out.println(i);
    }

    public static int singleNumber2(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}
