class Solution {
    
    static class Point {
        int row;
        int col;
        
        Point(int r, int c) {
            row = r;
            col = c;
        }
        
        Point left() {
            if (col == 0) {
                return null;
            }
            return new Point(row, col-1);
        }
        
        Point right(int colLimit) {
            if (col+1 == colLimit) {
                return null;
            }
            return new Point(row, col+1);
        }
        
        Point up() {
            if (row == 0) {
                return null;
            }
            return new Point(row-1, col);
        }
        
        Point down(int rowLimit) {
            if (row+1 == rowLimit) {
                return null;
            }
            return new Point(row+1, col);
        }
    }
    
    private static final int ISLAND_MARKER = 1;
    private static final int SEE_MARKER = 0;
    private static final int VISITED_MARKER = 2;
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] != 1) {
                    continue;
                }
                int currArea = area(row, col, grid);
                maxArea = Math.max(currArea, maxArea);
            }
        }
        return maxArea;
    }
    
    private int area(int row, int col, int[][]grid) {
        int area = 0;
        Deque<Point> pointQueue = new ArrayDeque<>();
        pointQueue.addLast(new Point(row, col));
        while (! pointQueue.isEmpty()) {
            Point p = pointQueue.removeFirst();
            if (grid[p.row][p.col] == ISLAND_MARKER) {
                area++;
                grid[p.row][p.col] = VISITED_MARKER;
                Point left = p.left();
                if (left != null) {
                    pointQueue.addLast(left);
                }
                Point right = p.right(grid[p.row].length);
                if (right != null) {
                    pointQueue.addLast(right);
                }
                Point up = p.up();
                if (up != null) {
                    pointQueue.addLast(up);
                }
                Point down = p.down(grid.length);
                if (down != null) {
                    pointQueue.addLast(down);
                }
            }
        }        
        return area;
    }
}