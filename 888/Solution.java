class Solution {
    public int[] fairCandySwap(final int[] A, final int[] B) {
        final Set<Integer> uniqueNumsInA = new HashSet<>();
        int sumA = 0;
        for (final int num : A) {
            uniqueNumsInA.add(num);
            sumA += num;
        }
        int sumB = 0;
        for (final int num : B) {
            sumB += num;
        }
        final int equalSum = (sumA+sumB) / 2;
        for (final int num : B) {
            final int changeTarget = equalSum-sumB+num;
            if (uniqueNumsInA.contains(changeTarget)) {
                return new int[] {changeTarget, num};
            }
        }
        return new int[] {0, 0};    // cannot happen
    }
}

