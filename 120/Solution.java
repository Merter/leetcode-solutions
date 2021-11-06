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

    private int minimumTotalWithIteration(List<List<Integer>> triangle) {
        for (int row=1; row<triangle.size(); row++) {
            for (int col=0; col<triangle.get(row).size(); col++) {
                if (col == 0) {
                    triangle.get(row).set(0, triangle.get(row).get(0) + triangle.get(row-1).get(0));
                    continue;
                }
                if (row == col) {
                    triangle.get(row).set(
                        col, triangle.get(row).get(col) + triangle.get(row-1).get(col-1));
                    continue;
                }
                triangle.get(row).set(
                    col, 
                    triangle.get(row).get(col) + 
                    Math.min(
                        triangle.get(row-1).get(col-1),
                        triangle.get(row-1).get(col)));
            }
        }
        int minTotal = Integer.MAX_VALUE;
        for (int pathSum : triangle.get(triangle.size()-1)) {
            minTotal = Math.min(minTotal, pathSum);
        }
        return minTotal;
    }
    
    private int minimumTotalWithRecursion(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, 0, 0);
    }
        
    private int minimumTotal(List<List<Integer>> triangle, int sum, int row, int col) {
        if (row == triangle.size()) {
            return sum;
        }
        return Math.min(
            minimumTotal(triangle, sum+triangle.get(row).get(col), row+1, col),
            minimumTotal(triangle, sum+triangle.get(row).get(col), row+1, col+1));
    }
}
