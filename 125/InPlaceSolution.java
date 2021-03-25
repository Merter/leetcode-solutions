public class InPlaceSolution {
    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length()-1;
        s = s.toLowerCase();
        while (begin < end) {
            if ((s.charAt(begin)-'a'>=0 && s.charAt(begin)-'a'<26) || (s.charAt(begin)-'0'>=0 && s.charAt(begin)-'0'<10)) {
                if ((s.charAt(end)-'a'>=0 && s.charAt(end)-'a'<26) || (s.charAt(end)-'0'>=0 && s.charAt(end)-'0'<10)) {
                    if (s.charAt(begin) != s.charAt(end)) {
                        return false;
                    }
                    begin++;
                    end--;
                } else {
                    end--;
                }
            } else {
                begin++;
            }
        }
        return true;
    }
}