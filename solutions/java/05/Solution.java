public class Solution {

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int len = s.length();
        int offset = 0;
        int maxLen = 1;
        boolean[][] table = new boolean[len][len];
        for (int i=0; i<len; i++) {
            table[i][i] = true;
        }
        for (int i=0; i<len-1; i++) {
            table[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if (table[i][i+1]) {
                offset = i;
                maxLen = 2;
            }
        }
        for (int i=len-1; i>=0; i--) {
            for (int j=i+2; j<len; j++) {  // j为什么从i+2开始？因为j=i+1的情况 在上面的循环里已经处理了
                table[i][j] = table[i+1][j-1] && s.charAt(i) == s.charAt(j);
                if (table[i][j] && j - i + 1 > maxLen) {
                    offset = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(offset, maxLen);
    }
}
