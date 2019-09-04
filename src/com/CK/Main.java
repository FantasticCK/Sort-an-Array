package com.CK;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString((new Solution().sortArray(new int[]{5, 2, 3, 1}))));
    }
}

class Solution4 {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return new int[0];

        quickSort(nums, 0, len - 1);

        return nums;
    }

    public void quickSort(int[] arr, int start, int end) {

        int partition = partition(arr, start, end);

        if (partition - 1 > start) {
            quickSort(arr, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSort(arr, partition + 1, end);
        }
    }

    public int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, start, i);
                start++;
            }
        }

        swap(arr, start, end);

        return start;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


class Solution2 {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return new int[0];

        quickSort(nums, 0, len - 1);

        return nums;
    }


    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }
}

// Merge Sort
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length == 0) return nums;

        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1, t = 0;
        int[] temp = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t] = nums[i];
                i++;
                t++;
            } else {
                temp[t] = nums[j];
                j++;
                t++;
            }
        }

        while (i <= mid) {
            temp[t] = nums[i];
            i++;
            t++;
        }

        while (j <= right) {
            temp[t] = nums[j];
            j++;
            t++;
        }

        t = 0;
        for (int n = left; n <= right; n++) {
            nums[n] = temp[t++];
        }
    }
}