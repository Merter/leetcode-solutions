/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIteratorWithIndex implements Iterator<Integer> {

    private List<Integer> flatList;
    private int pos;

    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList != null) {
            flatList = flattenNestedList(nestedList);
            pos = 0;
        }
    }

    private List<Integer> flattenNestedList(List<NestedInteger> nestedList) {
        List<Integer> flatList = new ArrayList<>();
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger())
                flatList.add(ni.getInteger());
            else {
                List<Integer> subFlatList = flattenNestedList(ni.getList());
                flatList.addAll(subFlatList);
            }
        }
        return flatList;
    }
    
    @Override
    public Integer next() {
        if (!hasNext())
            return null;
        return flatList.get(pos++);
    }

    @Override
    public boolean hasNext() {
        if (pos == flatList.size())
            return false;
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */