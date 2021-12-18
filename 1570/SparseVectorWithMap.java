class SparseVectorWithMap {
    
    Map<Integer, Integer> index2Value = new HashMap<>();
    
    SparseVector(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                index2Value.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for (Map.Entry<Integer, Integer> indexAndValue : index2Value.entrySet()) {
            int index = indexAndValue.getKey();
            int value = indexAndValue.getValue();
            Integer otherValue = vec.index2Value.get(index);
            if (otherValue != null) {
                result += value*otherValue;
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
