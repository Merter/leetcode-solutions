class Solution {
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for (int i=1; i<strs.length; i++) {
            commonPrefix = commonPrefix(commonPrefix, strs[i]);
            if ("".equals(commonPrefix)) {
                return "";
            }
        }
        return commonPrefix;
    }
    
    private String commonPrefix(String first, String second) {
        StringBuilder stb = new StringBuilder();
        for (int i=0; i<Math.min(first.length(), second.length()); i++) {
            if (first.charAt(i) == second.charAt(i)) {
                stb.append(first.charAt(i));
            } else {
                break;
            }
        }
        return stb.toString();
    }
}
