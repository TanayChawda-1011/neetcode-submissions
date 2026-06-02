class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur = new ArrayList<>();

        backtrack(nums, 0, cur, target);
        return res;
    }

    public void backtrack(int[] nums, int i, List<Integer> cur, int target) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if(target < 0 || i >= nums.length)
            return;

        // Decision to add nums[i]
        cur.add(nums[i]);
        backtrack(nums, i, cur, target - nums[i]);

        // decision to skip nums[i]
        cur.remove(cur.size() - 1);
        backtrack(nums, i + 1, cur, target);
    }
}
