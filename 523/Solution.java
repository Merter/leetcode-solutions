class Solution {
    public boolean checkSubarraySum(final int[] nums, final int k) {
        if (nums.length == 1) {
            return false;
        }
        if (k == 1) {
            return true;
        }
        final Set<Integer> uniqueSums = new HashSet<>();
        uniqueSums.add(0);
        int sum = 0;
        int consecutiveZeroCount = 0;
        for (int end=0; end<nums.length; end++) {
            final int num = nums[end]%k;
            if (num == 0) {
                if (consecutiveZeroCount == 1) {
                    return true;
                }
                consecutiveZeroCount = 1;
                continue;
            }
            consecutiveZeroCount = 0;
            sum += num;
            sum %= k;
            if (uniqueSums.contains(sum)) {
                return true;
            }
            uniqueSums.add(sum);
        }
        return false;
    }
}
