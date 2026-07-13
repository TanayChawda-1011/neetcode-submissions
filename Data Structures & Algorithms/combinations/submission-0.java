class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(n, 1, subset, k);
        return res;
    }

    public void backtrack(int n, int i, List<Integer> subset, int k) {
        if(subset.size() == k) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if(i > n)   return;

        subset.add(i);
        backtrack(n, i + 1, subset, k);

        subset.remove(subset.size() - 1);
        backtrack(n, i + 1, subset, k);
    }
}