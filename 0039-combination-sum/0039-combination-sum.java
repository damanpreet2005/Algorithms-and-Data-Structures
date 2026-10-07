class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combSum(0, candidates, new ArrayList<>(), result, target);
        return result;
    }

    public void combSum(int i, int[] candidates, List<Integer> current, List<List<Integer>> result, int target){
        // base case
        if( target == 0 ){
            result.add( new ArrayList<>(current) );
            return;
        }
        if( target < 0 || i == candidates.length){
            return;
        }

        // other cases
        current.add( candidates[i] );
        //combSum(i + 1 , candidates, current, result, target - candidates[i]); // increment single
        combSum(i, candidates, current, result, target - candidates[i]); // increment multiple
        current.remove( current.size() - 1 );
        combSum(i + 1, candidates, current, result, target); // exclude
    }
}