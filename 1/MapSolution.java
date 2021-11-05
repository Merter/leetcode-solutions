class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num2Index = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int pairToTarget = target - nums[i];
            Integer pairIndex = num2Index.get(pairToTarget);
            if (pairIndex == null) {
                num2Index.put(nums[i], i);
                continue;
            }
            return new int[]{pairIndex, i};
        }
        return null;    // cannot happen
    }
}
