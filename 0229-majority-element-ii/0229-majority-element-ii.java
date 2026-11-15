class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int elm1 = 0, elm2 = 0;
        int cnt1 = 0, cnt2 = 0;

        for (int num : nums) {
            if (elm1 == num) {
                cnt1++;
            } else if (elm2 == num) {
                cnt2++;
            } else if (cnt1 == 0){
                elm1 = num;
                cnt1++;
            } else if (cnt2 == 0) {
                elm2 = num;
                cnt2++;
            }  else {
                cnt1--;
                cnt2--;
            }
        }

        //check whether the number is occuring more than n/3
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (elm1 == num) cnt1++;
            if (elm2 == num) cnt2++;
        }

        int limit = nums.length / 3;

        if (cnt1 > limit) result.add(elm1);
        if (cnt2 > limit && elm1 != elm2) result.add(elm2);

        return result;
    }
}