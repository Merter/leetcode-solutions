public class Solution {
    
	private int minRemoval = Integer.MAX_VALUE;
	private Set<String> validParantheses;
	private char[] content; 
    
    public List<String> removeInvalidParentheses(String s) {
		content = s.toCharArray();
		remove(0, 0, 0, "");
		return generateList();
    }
    
    // currentParantheses keep the already read left part
	private void remove(
        int start, int removed, int unmatchedOpenCount, String consumedLeftPart) {
		if (start == content.length) {
			if (unmatchedOpenCount == 0) {
                // this is the end of a valid expresssion
				if (removed == minRemoval) {
                    // add to the list, since this is one of the minimums
					validParantheses.add(consumedLeftPart);
				}
				if (removed < minRemoval) {
                    // a new minimum removal is found
                    // discard all previous ones and create a new list
					validParantheses = new HashSet<String>();
					validParantheses.add(consumedLeftPart);
					minRemoval = removed;
				}
			}
			return;
		}
		if (unmatchedOpenCount < 0) {
            // no need to proceed, since this is now an invalid expression
            return;            
        }
		if (content[start]!='(' && content[start]!=')') {
            // discard the current char and recurse as if it is not present
			remove(start+1, removed, unmatchedOpenCount, consumedLeftPart+content[start]);
			return;
		}
        // first, try with discarding the current char
		remove(start+1, removed+1, unmatchedOpenCount, consumedLeftPart);
		if (content[start] == '(') {
			unmatchedOpenCount++;
		}
		if (content[start] == ')') {
			unmatchedOpenCount--;
		}
        // second, accept the current char and try to find if that creates a valid expression
		remove(start+1, removed, unmatchedOpenCount, consumedLeftPart+content[start]);
	}
	
	private List<String> generateList() {
		List<String> parantheses = new LinkedList<String>();
		for (String s : validParantheses) {
			parantheses.add(s);
		}
		return parantheses;
	}
}
