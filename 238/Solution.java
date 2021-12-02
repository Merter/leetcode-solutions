class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productsExceptSelf = new int[nums.length];
        productsExceptSelf[0] = 1;
        for (int i=1; i<nums.length; i++) {
            productsExceptSelf[i] = productsExceptSelf[i-1]*nums[i-1];
        }
        int cumulativeProductFromRight = nums[nums.length-1];
        for (int i=nums.length-2; i>=0; i--) {
            productsExceptSelf[i] *= cumulativeProductFromRight;
            cumulativeProductFromRight *= nums[i];
        }
        return productsExceptSelf;
    }
}
