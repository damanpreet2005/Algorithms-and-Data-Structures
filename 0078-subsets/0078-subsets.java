class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result){
        //Base case
        if (index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        //Include
        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);

        //Exclude
        current.remove(current.size() - 1);
        backtrack(index + 1, nums, current, result);
    }
}