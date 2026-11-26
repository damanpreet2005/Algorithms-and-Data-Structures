class Solution {
    public void nextPermutation(int[] nums) {
        int successor = nums[nums.length - 1];
        int pivot = -1;

        // finding the pivot - O(n)
        for (int i = nums.length - 2; i >= 0; i--) {

            if (nums[i] < nums[i + 1]) {
                pivot = i;

                // finding the successor - O(n)
                if (i >= 0) {
                    int succ_idx = -1;

                    for (int j = nums.length - 1; j > i; j--) {
                        if (nums[j] > nums[i]) {
                            succ_idx = j;
                            break;
                        }
                    }

                    // swap
                    int temp = nums[pivot];
                    nums[pivot] = nums[succ_idx];
                    nums[succ_idx] = temp;
                } 

                break;
            }
        }

        // reverse the array
        int left = pivot + 1;
        int right = nums.length - 1;
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left ++;
            right --;
        }
    }
}