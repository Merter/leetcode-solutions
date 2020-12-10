class Solution {
    public int maxProduct(int[] nums) {
        return greedyMaxProduct(nums);
    }

    private int bruteForceMaxProduct(int[] nums) {
        int largestProduct = Integer.MIN_VALUE;
        for (int begin=0; begin<nums.length; begin++) {
            for (int end=begin; end<nums.length; end++) {
                int product = 1;
                for (int i=begin; i<=end; i++) {
                    product *= nums[i];
                }
                if (product > largestProduct) {
                    largestProduct = product;
                }
            }
        }
        return largestProduct;    
    }

    private int betterMaxProduct(int[] nums) {
        int largestProduct = Integer.MIN_VALUE;
        for (int begin=0; begin<nums.length; begin++) {
            int product = 1;
            for (int end=begin; end<nums.length; end++) {
                product *= nums[end];
                if (product > largestProduct) {
                    largestProduct = product;
                }
            }
        }
        return largestProduct;
    }

    private int greedyMaxProduct(int[] nums) {
        int largestProduct = nums[0];
        int prevCumulativeMinProduct = nums[0];
        int prevCumulativeMaxProduct = nums[0];
        for (int i=1; i<nums.length; i++) {
            int currMin = prevCumulativeMinProduct * nums[i];
            int currMax = prevCumulativeMaxProduct * nums[i];

            prevCumulativeMinProduct = Math.min(Math.min(currMin, currMax), nums[i]);
            prevCumulativeMaxProduct = Math.max(Math.max(currMin, currMax), nums[i]);

            if (prevCumulativeMaxProduct > largestProduct) {
                largestProduct = prevCumulativeMaxProduct;
            }
        }
        return largestProduct;
    }
}
