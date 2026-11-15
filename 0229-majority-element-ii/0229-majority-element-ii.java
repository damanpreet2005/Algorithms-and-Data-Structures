class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int limit = nums.length / 3;

        // create the count map
        for (int num : nums) {
            map.put( num, map.getOrDefault(num, 0) + 1);
        }

        // iterate the count map
        for (int num : map.keySet()) {
            if (map.get(num) > limit){
                result.add(num);
            }
        }

        return result;
    }
}