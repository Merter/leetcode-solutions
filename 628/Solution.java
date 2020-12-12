class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int maxProductOfThree = nums[nums.length-1];
        maxProductOfThree *= nums[nums.length-2];
        maxProductOfThree *= nums[nums.length-3];
        if (nums.length == 3) {
            return maxProductOfThree;
        }
        if (nums[0] < 0) {
            int twoNegativesAndOnePositive = nums[0]*nums[1]*nums[nums.length-1];
            if (twoNegativesAndOnePositive > maxProductOfThree) {
                maxProductOfThree = twoNegativesAndOnePositive;
            }
        }
        return maxProductOfThree;
    }
}
