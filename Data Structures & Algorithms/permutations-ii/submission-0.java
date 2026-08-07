class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        int[] pick = new int[nums.length];

        backtrack(nums, pick, subset, res);
        return new ArrayList<>(res);
    }

    public void backtrack(int[] nums, int[] pick, List<Integer> subset, Set<List<Integer>> res) {
        if(subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(pick[i] == 0) {
                pick[i] = 1;
                subset.add(nums[i]);

                backtrack(nums, pick, subset, res);

                subset.remove(subset.size() - 1);
                pick[i] = 0;
            }
        }
    }
}