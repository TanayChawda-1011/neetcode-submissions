class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(candidates, 0, target, cur);
        return res;
    }

    public void backtrack(int[] candidates, int i, int target, List<Integer> cur) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if(target < 0 || i == candidates.length)
            return;

        cur.add(candidates[i]);
        backtrack(candidates, i + 1, target - candidates[i], cur);

        cur.remove(cur.size() - 1);

        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1])
            i++;

        backtrack(candidates, i + 1, target, cur);        
    }
}
