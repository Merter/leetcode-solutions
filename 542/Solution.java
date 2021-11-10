class Solution {
    
    private static final int ONE_MARKER = -1;
    
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
        
        int valueIn(int[][] grid) {
            return grid[row][col];
        }
        
        public int hashCode() {
            int result = 17;
            result = 31*result + row;
            result = 31*result + col;
            return result;
        }
        
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Point)) {
                return false;
            }
            Point otherPoint = (Point)other;
            if (this.row != otherPoint.row) {
                return false;
            }
            if (this.col != otherPoint.col) {
                return false;
            }
            return true;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int level = 0;
        Set<Point> pointsInLevel = new HashSet<>();
        for (int row=0; row<mat.length; row++) {
            for (int col=0; col<mat[row].length; col++) {
                if (mat[row][col] == 0) {
                    pointsInLevel.add(new Point(row, col));
                } else {
                    mat[row][col] = ONE_MARKER;
                }
            }
        }
        Set<Point> pointsInNextLevel = new HashSet<>();
        while (true) {
            for (Point p : pointsInLevel) {
                mat[p.row][p.col] = level;
                Point left = p.left();
                if (left!=null && left.valueIn(mat)==ONE_MARKER && !pointsInLevel.contains(left)) {
                    pointsInNextLevel.add(left);
                }
                Point right = p.right(mat[0].length);
                if (right!=null && right.valueIn(mat)==ONE_MARKER && !pointsInLevel.contains(right)) {
                    pointsInNextLevel.add(right);
                }
                Point up = p.up();
                if (up!=null && up.valueIn(mat)==ONE_MARKER && !pointsInLevel.contains(up)) {
                    pointsInNextLevel.add(up);
                }
                Point down = p.down(mat.length);
                if (down!=null && down.valueIn(mat)==ONE_MARKER && !pointsInLevel.contains(down)) {
                    pointsInNextLevel.add(down);
                }
            }
            if (pointsInNextLevel.isEmpty()) {
                return mat;
            }
            level++;
            pointsInLevel = pointsInNextLevel;
            pointsInNextLevel = new HashSet<>();
        }
    }
}
