class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>(numRows);
        pascalTriangle.add(Arrays.asList(new Integer[]{1}));
        if (numRows == 1) {
            return pascalTriangle;
        }
        List<Integer> prevRow = Arrays.asList(new Integer[]{1, 1});
        pascalTriangle.add(prevRow);
        for (int i=3; i<=numRows; i++) {
            List<Integer> nextRow = generateNextRow(prevRow);
            pascalTriangle.add(nextRow);
            prevRow = nextRow;
        }
        return pascalTriangle;
    }
    
    private List<Integer> generateNextRow(List<Integer> prevRow) {
        List<Integer> nextRow = new ArrayList<>(prevRow.size()+1);
        nextRow.add(1);
        Iterator<Integer> iterator = prevRow.iterator();
        int prev = iterator.next();
        while (iterator.hasNext()) {
            int curr = iterator.next();
            nextRow.add(prev+curr);
            prev = curr;
        }
        nextRow.add(1);
        return nextRow;
    }
}
