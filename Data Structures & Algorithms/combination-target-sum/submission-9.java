class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(nums, 0, subset, target, res);
        return res;
    }

    public void backtrack(int[] nums, int i, List<Integer> subset, int target, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if(i == nums.length || target < 0)  return;

        subset.add(nums[i]);
        
        backtrack(nums, i, subset, target - nums[i], res);
        subset.remove(subset.size() - 1);

        backtrack(nums, i + 1, subset, target, res);
    }
}
