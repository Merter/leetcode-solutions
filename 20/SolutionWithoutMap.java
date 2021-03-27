class SolutionWithoutMap
{
  public boolean isValid(String s)
  {
    final ArrayDeque<Character> stack = new ArrayDeque<>();
    for (int i=0; i<s.length(); i++)
    {
      if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
      {
        stack.push(s.charAt(i));
      }
      else
      {
        if (stack.isEmpty())
        {
          return false;
        }
        final char topChar = stack.pop();
        if (s.charAt(i) == ')' && topChar != '(')
        {
          return false;
        }
        if (s.charAt(i) == '}' && topChar != '{')
        {
          return false;
        }
        if (s.charAt(i) == ']' && topChar != '[')
        {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}