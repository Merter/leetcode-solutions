class Solution {
    public int leastBricks(final List<List<Integer>> wall) {
        int wallLength = 0;
        for (final Integer brick : wall.get(0)) {
            wallLength += brick;
        }
        int maxCount = 0;
        final Map<Integer, Integer> brickEndLength2Count = new HashMap<>();
        for (final List<Integer> rowBricks : wall) {
            int sum = 0;
            for (final Integer brick : rowBricks) {
                sum += brick;
                if (sum == wallLength) {
                    break;
                }
                Integer count = brickEndLength2Count.get(sum);
                if (count == null) {
                    count = 0;
                }
                brickEndLength2Count.put(sum, ++count);
                maxCount = Math.max(maxCount, count);
            }
        }
        return wall.size()-maxCount;
    }
}
