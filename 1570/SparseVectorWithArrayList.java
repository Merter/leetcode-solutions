class SparseVectorWithArrayList {
    
    List<int[]> indexValuePairs = new ArrayList<>();
    
    SparseVector(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                indexValuePairs.add(new int[]{i, nums[i]});
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        int thisIndex = 0;
        int vecIndex = 0;
        while (thisIndex < indexValuePairs.size()) {
            int[] thisIndexValuePair = indexValuePairs.get(thisIndex);
            while (vecIndex < vec.indexValuePairs.size()) {
                int[] vecIndexValuePair = vec.indexValuePairs.get(vecIndex);
                if (vecIndexValuePair[0] == thisIndexValuePair[0]) {
                    result += thisIndexValuePair[1] * vecIndexValuePair[1];
                    thisIndex++;
                    vecIndex++;
                    break;
                }
                if (vecIndexValuePair[0] > thisIndexValuePair[0]) {
                    thisIndex++;
                    break;
                }
                vecIndex++;
            }
            if (vecIndex == vec.indexValuePairs.size()) {
                return result;
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);