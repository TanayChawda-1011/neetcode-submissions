class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int[] pick = new int[nums.length];

        backtrack(nums, subset, pick);

        return res;
    }

    public void backtrack(int[] nums, List<Integer> subset, int[] pick) {
        if(subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(pick[i] == 0) {
                pick[i] = 1;
                subset.add(nums[i]);

                backtrack(nums, subset, pick);

                subset.remove(subset.size() - 1);
                pick[i] = 0;
            }
        }
    }
}
