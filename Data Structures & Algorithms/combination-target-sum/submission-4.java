class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur = new ArrayList<>();

        backtrack(nums, 0, target, cur);
        return res;
    }

    public void backtrack(int[] nums, int i, int target, List<Integer> cur) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if(target < 0 || i >= nums.length)
            return;
        
        // decision to include nums[i]
        cur.add(nums[i]);
        backtrack(nums, i, target - nums[i], cur);

        // decision to exlude nums[i]
        cur.remove(cur.size() - 1);
        backtrack(nums, i + 1, target, cur);
    }
}
