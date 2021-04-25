class Solution {
    public int[][] intervalIntersection(final int[][] firstList, final int[][] secondList) {
        int firstIndex = 0;
        int secondIndex = 0;
        final List<int[]> intervalIntersectionsAsList = new ArrayList<>();
        while (firstIndex<firstList.length && secondIndex<secondList.length) {
            final int [] intersectingInterval = 
                intersection(firstList[firstIndex], secondList[secondIndex]);
            if (intersectingInterval != null) {
                intervalIntersectionsAsList.add(intersectingInterval);
            }
            if (firstList[firstIndex][1] == secondList[secondIndex][1]) {
                firstIndex++;
                secondIndex++;
            } else if (firstList[firstIndex][1] < secondList[secondIndex][1]) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }
        final int[][] intervalIntersections = new int[intervalIntersectionsAsList.size()][];
        int i = 0;
        for (final int[] intervalIntersection : intervalIntersectionsAsList) {
            intervalIntersections[i++] = intervalIntersection;
        }
        return intervalIntersections;        
    }
    
    private int[] intersection(final int[] first, final int[] second) {
        if (second[0]<=first[0] && first[0]<=second[1]) {
            return new int[]{first[0], Math.min(first[1], second[1])};
        }
        if (first[0]<=second[0] && second[0]<=first[1]) {
            return new int[]{second[0], Math.min(first[1], second[1])};
        }
        return null;
    }
}
