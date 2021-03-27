class Solution {
    public int threeSumClosest(int[] nums, int targetToThree) {
        Arrays.sort(nums);
        int first = 0;
        int nearestToTarget = Integer.MAX_VALUE / 2;
        while (first < nums.length-2) {
            final int targetForTwo = targetToThree-nums[first];
            int second = first+1;
            while (second < nums.length-1) {
                final int target = targetForTwo-nums[second];
                final int third = Arrays.binarySearch(nums, second+1, nums.length, target);
                if (third > second) {
                    return targetToThree;                    
                }
                int nearestPosition = -(third+1);
                if (nearestPosition==nums.length) {
                    final int currentSum = nums[first] + nums[second] + nums[nums.length-1];
                    if (Math.abs(nearestToTarget-targetToThree) > Math.abs(currentSum-targetToThree)) {
                        nearestToTarget = currentSum;
                    }
                } else {
                    int currentSum = nums[first] + nums[second] + nums[nearestPosition];
                    if (Math.abs(nearestToTarget-targetToThree) > Math.abs(currentSum-targetToThree)) {
                        nearestToTarget = currentSum;
                    }                    
                    if (nearestPosition-1 >= second+1) {
                        currentSum = nums[first] + nums[second] + nums[nearestPosition-1];
                        if (Math.abs(nearestToTarget-targetToThree) > Math.abs(currentSum-targetToThree)) {
                            nearestToTarget = currentSum;
                        }
                    }
                }
                second++;
                while (second<nums.length-1 && nums[second-1]==nums[second]) {
                    second++;
                }
            }
            first++;
            while (first<nums.length-2 && nums[first-1]==nums[first]) {
                first++;
            }                        
        }
        return nearestToTarget;
    }
}

