class Solution {
    public int distributeCandies(final int[] candyTypes) {
        final Set<Integer> uniqueCandyTypes = new HashSet<>();
        for (int candyType : candyTypes) {
            uniqueCandyTypes.add(candyType);
        }
        return Math.min(candyTypes.length/2, uniqueCandyTypes.size());
    }
}