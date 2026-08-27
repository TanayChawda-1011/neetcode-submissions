class Solution {    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> perm = new ArrayList<>();

        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        backtrack(nums, perm, count, res);

        return res;
    }

    public void backtrack(int[] nums, List<Integer> perm, Map<Integer, Integer> count, List<List<Integer>> res) {
        if(perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int num : count.keySet()) {
            if(count.get(num) > 0) {
                perm.add(num);
                count.put(num, count.get(num) - 1);

                backtrack(nums, perm, count, res);

                count.put(num, count.get(num) + 1);
                perm.remove(perm.size() - 1);
            }
        }
    }
}