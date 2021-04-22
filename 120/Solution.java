class Solution {
    public int minimumTotal(final List<List<Integer>> triangle) {
        final int triSize = triangle.size();
        for (int row=triSize-2; row>=0; row--) {
            for (int col=0; col<=row; col++) {
                final int parent = triangle.get(row).get(col);
                final int minChild = Math.min(triangle.get(row+1).get(col), triangle.get(row+1).get(col+1));
                triangle.get(row).set(col, parent+minChild);
            }
        }
        return triangle.get(0).get(0);
    }    
}
