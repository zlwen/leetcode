class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            int index = sb.indexOf(s.charAt(i) + "");
            if (index >= 0) {
                if (sb.length() > count) {
                    count = sb.length();
                }
                sb.delete(0, index+1);
                sb.append(s.charAt(i));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return count > sb.length() ? count : sb.length();
    }
}
