class Solution {
    public int findMin(int[] nums) {
        int si = 0;
        int ri = nums.length - 1;

        while (si < ri){
            int mid = si + (ri - si) / 2; 

            if (nums[ri] < nums[mid]) {
                si = mid + 1;
            } else {
                ri = mid;
            }
        } 
        return nums[si];
    }
}