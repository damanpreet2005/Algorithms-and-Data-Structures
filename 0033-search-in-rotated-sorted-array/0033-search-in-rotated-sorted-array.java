class Solution {
    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] >= nums[si]) { // L1
                if ( nums[si] <= target && target <= nums[mid]){ // Left of L1
                    ei = mid - 1;
                } else { // Right of L1
                    si = mid + 1;
                }
            } else { // L2
                if (nums[mid] <= target && target <= nums[ei]){ // Right of L2
                    si = mid + 1;
                } else { // Left of L2
                    ei = mid - 1;
                }
            }
        }

        return -1;
    }
}