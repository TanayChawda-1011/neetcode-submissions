class Solution {
    public boolean isAnagram(String s, String t) {        
        if(s.length() != t.length())   return false;
        
        int[] alphas = new int[26];

        for(char c : s.toCharArray())
            alphas[c - 'a']++;

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if(alphas[c - 'a'] == 0)  return false;
            alphas[c - 'a']--;
        }

        return true;
    }
}
