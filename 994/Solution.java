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
    
    private static final int FRESH_MARKER = 1;
    private static final int EMPTY_MARKER = 0;
    private static final int ROTTEN_MARKER = 2;
    
    public int orangesRotting(int[][] grid) {
        Set<Point> currentRottens = new HashSet<>();
        int remainingFreshCount = 0;
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] == ROTTEN_MARKER) {
                    currentRottens.add(new Point(row, col));
                }
                if (grid[row][col] == FRESH_MARKER) {
                    remainingFreshCount++;
                }
            }
        }
        int minTime = 0;
        Set<Point> nextRottens = new HashSet<>();
        while (true) {
            for (Point rot : currentRottens) {
                if (rot.valueIn(grid) == FRESH_MARKER) {
                    remainingFreshCount--;
                    grid[rot.row][rot.col] = ROTTEN_MARKER;
                    nextRottens.remove(rot);
                }
                Point left = rot.left();
                if (left!=null && left.valueIn(grid)==FRESH_MARKER) {
                    nextRottens.add(left);
                }

                Point right = rot.right(grid[0].length);
                if (right!=null && right.valueIn(grid)==FRESH_MARKER) {
                    nextRottens.add(right);
                }

                Point up = rot.up();
                if (up!=null && up.valueIn(grid)==FRESH_MARKER) {
                    nextRottens.add(up);
                }

                Point down = rot.down(grid.length);
                if (down!=null && down.valueIn(grid)==FRESH_MARKER) {
                    nextRottens.add(down);
                }
            }    
            if (nextRottens.isEmpty()) {
                break;
            }
            minTime++;
            currentRottens = nextRottens;
            nextRottens = new HashSet<>();
        }
        return remainingFreshCount==0 ? minTime : -1;
    }
}