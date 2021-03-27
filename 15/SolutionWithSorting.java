class SolutionWithSorting {
    public List<List<Integer>> threeSum(int[] nums) {
        final List<List<Integer>> uniqueTriplets = new ArrayList<>();
        Arrays.sort(nums);
        int first = 0;
        while (first < nums.length-2) {
            final int targetForTwo = -nums[first];
            int second = first+1;
            while (second < nums.length-1) {
                final int target = targetForTwo-nums[second];
                final int third = Arrays.binarySearch(nums, second+1, nums.length, target);
                if (third > second) {
                    final List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[first]);
                    triplet.add(nums[second]);
                    triplet.add(nums[third]);
                    uniqueTriplets.add(triplet);                    
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
        return uniqueTriplets;
    }
}

