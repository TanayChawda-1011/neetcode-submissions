class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];
        int n = nums.length;

        System.arraycopy(nums, 0, res, 0, n);
        System.arraycopy(nums, 0, res, n, n);

        return res;
    }
}