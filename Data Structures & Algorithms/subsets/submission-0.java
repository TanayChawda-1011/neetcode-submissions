class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        dfs(nums, 0, res, subset);
        return res;
    }

    public void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> subset) {
        if(i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // Decision to include the nums[i]
        subset.add(nums[i]);
        dfs(nums, i + 1, res, subset);

        // Decision to not include the nums[i] element
        subset.remove(subset.size() - 1);   //negating the previous '.add()'
        dfs(nums, i + 1, res, subset);        
    }
}
