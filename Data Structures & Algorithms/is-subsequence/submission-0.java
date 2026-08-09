class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)     return true;
        if(t.length() == 0)     return false;
        
        int p1 = 0, p2 = 0;
        int sLen = s.length(), tLen = t.length();

        while(p1 < sLen && p2 < tLen) {
            if(s.charAt(p1) == t.charAt(p2))
                p1++;
            p2++;
        }

        return p1 == sLen ? true : false;
    }
}