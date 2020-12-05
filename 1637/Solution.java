class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xAxis = new int[points.length];
        for (int i=0; i<points.length; i++) {
            int[] point = points[i];
            xAxis[i] = point[0];
        }
        Arrays.sort(xAxis);
        int maxDiff = 0;
        for (int i=1; i<xAxis.length; i++) {
            int diff = xAxis[i]-xAxis[i-1];
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
}
