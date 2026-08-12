class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            if (lastSeen[ch] >= l) {
                l = lastSeen[ch] + 1;
            }

            lastSeen[ch] = r;

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}