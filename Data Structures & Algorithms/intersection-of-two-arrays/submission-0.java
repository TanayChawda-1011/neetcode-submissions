class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();

        for(int n : nums1)
            seen.add(n);

        List<Integer> res = new ArrayList<>();
        for(int n : nums2) {
            if(seen.contains(n)) {
                res.add(n);
                seen.remove(n);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}