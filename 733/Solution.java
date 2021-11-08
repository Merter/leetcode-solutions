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
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        Deque<Point> pointQueue = new ArrayDeque<>();
        pointQueue.addLast(new Point(sr, sc));
        while (! pointQueue.isEmpty()) {
            Point p = pointQueue.removeFirst();
            if (image[p.row][p.col] != oldColor) {
                continue;
            }
            image[p.row][p.col] = newColor;
            Point left = p.left();
            if (left != null) {
                pointQueue.addLast(left);
            }
            Point right = p.right(image[p.row].length);
            if (right != null) {
                pointQueue.addLast(right);
            }
            Point up = p.up();
            if (up != null) {
                pointQueue.addLast(up);
            }
            Point down = p.down(image.length);
            if (down != null) {
                pointQueue.addLast(down);
            }
        }
        return image;
    }
}
