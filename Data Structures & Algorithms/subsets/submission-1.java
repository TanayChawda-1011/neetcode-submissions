class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();

        backtrack(nums, 0, subset);
        return res;
    }

    public void backtrack(int[] nums, int i, List<Integer>subset) {
        if(i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }


        // decision to include nums[i]
        subset.add(nums[i]);
        backtrack(nums, i + 1, subset);

        // decision to not include nums[i]
        subset.remove(subset.size() - 1);
        backtrack(nums, i + 1, subset);
    }
}
