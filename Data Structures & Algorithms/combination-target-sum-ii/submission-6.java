class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        // Sort the array first!
        // The only way we're able to skip past the duplicates is thru sorting!
        Arrays.sort(candidates);
        
        dfs(candidates, 0, subset, target);
        return res;
    }

    public void dfs(int[] candidates, int i, List<Integer> subset, int target) {
        if(target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }

        if(target < 0 || i == candidates.length)    return;

        // IMPORTANT PRUNING.
        //
        // Since the array is sorted, if candidates[i] > target,
        // then every element after i is also >= candidates[i] > target.
        //
        // Therefore, no combination starting from this index can
        // possibly reach the target, so we can safely stop exploring
        // this entire subtree.
        if(candidates[i] > target) return;

        // choice to include candidates[i]
        subset.add(candidates[i]);
        dfs(candidates, i + 1, subset, target - candidates[i]);

        // undo the change that we made for that call, to return the subset list to its previous glory
        subset.remove(subset.size() - 1);

        // choice to exclude candidates[i] and all duplicate occurences of it.
        while((i + 1) < candidates.length && candidates[i] == candidates[i + 1])
            i += 1;

        // by the end of the loop, the i will be pointing at the last occurence of the duplicate element
        // and since we are always going to call the dfs() with the value `i + 1`, it'll work just perfect.
        dfs(candidates, i + 1, subset, target);
    }
}
