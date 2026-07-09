class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> subset) {
        if(i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // process the current element by adding it.
        subset.add(nums[i]);

        // include the current ith element / node in the first call
        dfs(nums, i + 1, subset);

        // exclude the current element and do the same process for the second call
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset);
    }
}
