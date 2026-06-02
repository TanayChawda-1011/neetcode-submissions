class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> subset = new ArrayList<>();

        backtrack(0, target, subset, nums);
        return res;
    }

    public void backtrack(int i, int target, List<Integer> subset, int[] nums) {
        if(target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }

        if(target < 0 || i == nums.length)
            return;
        
        // decision to add nums[i]
        subset.add(nums[i]);
        backtrack(i, target - nums[i], subset, nums);


        subset.remove(subset.size() - 1);
        backtrack(i + 1, target, subset, nums);
    }
}
