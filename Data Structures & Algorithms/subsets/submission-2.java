class Solution {
    private List<List<Integer>> res =  new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<>();

        backtrack(0, cur, nums);
        return res;
    }

    public void backtrack(int i, List<Integer> cur, int[] nums) {
        if(i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // decision of including nums[i]
        cur.add(nums[i]);
        backtrack(i + 1, cur, nums);

        // decision to exclude the nums[i]
        cur.remove(Integer.valueOf(nums[i]));
        backtrack(i + 1, cur, nums);
    }
}
