class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];

        for(char c : s1.toCharArray())
            freq[c - 'a']++;

        int k = s1.length();
        int n = s2.length();
        int l = 0;

        for(int r = 0; r < n; r++) {
            freq[s2.charAt(r) - 'a']--;

            if(r - l + 1 > k) {
                freq[s2.charAt(l) - 'a']++;
                l++;
            }

            if(r - l + 1 == k) {
                boolean isZero = true;
                for(int i = 0; i < 26; i++) {
                    if(freq[i] != 0) {
                        isZero = false;
                        break;
                    }
                }

                if(isZero) return true;
            }
        }

        return false;
    }
}