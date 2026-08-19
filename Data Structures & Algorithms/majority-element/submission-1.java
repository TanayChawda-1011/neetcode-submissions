class Solution {
    public int majorityElement(int[] nums) {
        int threshold = nums.length / 2;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);

            if(map.get(n) > threshold)
                return n;
        }

        return -1;
    }
}