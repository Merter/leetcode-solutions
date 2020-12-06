class Solution {
    public String interpret(String command) {
        StringBuilder stb = new StringBuilder();
        char[] commandLetters = command.toCharArray();
        int i = 0;
        while (i < commandLetters.length) {
            if (commandLetters[i] == 'G') {
                stb.append(commandLetters[i]);
                i++;
            } else {
                // '('
                i++;
                if (commandLetters[i] == ')') {
                    stb.append('o');
                    i++;
                } else {
                    // "al)"
                    stb.append("al");
                    i += 3;
                }
            }
        }
        return stb.toString();
    }
}