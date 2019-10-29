package sort;

import java.util.Arrays;

/**
 * 排序算法
 *
 * @author :zhangshengjun
 * @create 2019-10-29 10:40
 **/
public class ArraySort {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 6, 0, 1, 4, 6, 3, 2, 0};
        bubbleSort(nums);
        selectSort(nums);
        insertSort1(nums);
        insertSort2(nums);
        //quickSort(nums, 0, nums.length - 1);
        quickSort2(nums, 0, nums.length - 1);
        System.out.println(nums);
    }


    /**
     * 快排
     *
     * @param arr
     * @return
     */
    public static void quickSort2(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }

        int left = start;
        int right = end;
        int base = arr[start];

        while (left != right) {
            // 找到右边第一个小于等于 base的数的位置
            while (arr[right] > base && left < right) {
                right--;
            }
            // 找到左边边第一个大于等于 base的数的位置
            while (arr[left] <= base && left < right) {
                left++;
            }
            swap(arr, left, right);
        }
        arr[start] = arr[left];
        arr[left] = base;

        quickSort2(arr, start, left - 1);
        quickSort2(arr, right + 1, end);

    }


    /**
     * 快排
     *
     * @param arr
     * @return
     */
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin > end) {
            return;
        }
        int left = begin;
        int right = end;
        int base = arr[begin];
        while (left != right) {
            // 找到右边第一个小于基数的位置
            while (arr[right] >= base && left < right) {
                right--;
            }
            // 找到右边第一个大于基数的位置
            while (arr[left] < base && left < right) {
                left++;
            }
            swap(arr, left, right);
        }

        arr[begin] = arr[left];
        arr[left] = base;
        //继续处理左边的，这里是一个递归的过程
        quickSort(arr, begin, left - 1);
        //继续处理右边的 ，这里是一个递归的过程
        quickSort(arr, right + 1, end);

    }

    /**
     * 选择
     *
     * @param arrays
     * @return
     */
    public static int[] insertSort2(int[] arrays) {
        int[] arr = Arrays.copyOf(arrays, arrays.length);
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = temp;
        }
        return arr;
    }


    /**
     * 选择
     *
     * @param arrays
     * @return
     */
    public static int[] insertSort1(int[] arrays) {
        int[] arr = Arrays.copyOf(arrays, arrays.length);
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    /**
     * 选择
     *
     * @param arrays
     * @return
     */
    public static int[] selectSort(int[] arrays) {
        int[] arr = Arrays.copyOf(arrays, arrays.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, j, i);
                }
            }
        }
        return arr;
    }


    /**
     * 冒泡
     *
     * @param arrays
     * @return
     */
    public static int[] bubbleSort(int[] arrays) {
        int[] arr = Arrays.copyOf(arrays, arrays.length);
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }


    /**
     * 交换
     *
     * @param nums
     * @param before
     * @param after
     */
    public static void swap(int[] nums, int before, int after) {
        int temp = nums[after];
        nums[after] = nums[before];
        nums[before] = temp;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;

    }
}
