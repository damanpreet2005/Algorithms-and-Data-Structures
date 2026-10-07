class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        backtrack(visited, nums, new ArrayList<>(), result);
        return result;

    }

    public void backtrack(boolean[] visited, int[] nums, List<Integer> current, List<List<Integer>> result){
        // base case
        if (current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        // other cases
        for(int i = 0; i < nums.length; i++){
            if (!visited[i]){
                visited[i] = true;
                current.add( nums[i] );
                backtrack(visited, nums, current, result);

                current.remove( current.size() - 1 );
                visited[i] = false;
            }
        }
    }
}