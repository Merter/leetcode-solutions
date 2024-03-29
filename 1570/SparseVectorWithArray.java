class SparseVectorWithArray {

    int[] mNums;
    
    SparseVector(int[] nums) {
        mNums = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for (int i=0; i<mNums.length; i++) {
            result += mNums[i]*vec.mNums[i];
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);