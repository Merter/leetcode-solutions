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
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIteratorWithListIterator implements Iterator<Integer> {

    private List<NestedInteger> nestedIntegers;
    private Deque<ListIterator<NestedInteger>> iteratorStack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedIntegers = nestedList;
        iteratorStack = new ArrayDeque<>();
        iteratorStack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        if (! hasNext()) {
            return null;
        }
        while (true) {
            final ListIterator<NestedInteger> iterator = iteratorStack.peek();
            final NestedInteger nestedInteger = iterator.next();
            if (nestedInteger.isInteger()) {
                return nestedInteger.getInteger();
            }
            iteratorStack.push(nestedInteger.getList().listIterator());
        }
    }

    @Override
    public boolean hasNext() {
        while (! iteratorStack.isEmpty()) {
            final ListIterator<NestedInteger> iterator = iteratorStack.peek();
            if (iterator.hasNext()) {
                final NestedInteger nestedInteger = iterator.next();
                if (nestedInteger.isInteger()) {
                    iterator.previous();
                    return true;
                }
                iteratorStack.push(nestedInteger.getList().listIterator());
                continue;
            }
            iteratorStack.pop();
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */