class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> subset = new ArrayList<>();

        backtrack(nums, 0, target, subset);
        return res;
    }

    public void backtrack(int[] nums, int i, int target, List<Integer> subset) {
        if(target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }

        if(target < 0 || i == nums.length)
            return;

        // decision to add 'nums[i]'
        subset.add(nums[i]);
        backtrack(nums, i, target - nums[i], subset);

        // decision to exclude 'nums[i]'
        subset.remove(subset.size() - 1);
        backtrack(nums, i + 1, target, subset);
    }
}
