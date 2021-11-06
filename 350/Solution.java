class Solution {
    
    private static final int MAX_NUM = 1000;
    
    public int[] intersect(int[] nums1, int[] nums2) {
        return intersectBySorting(nums1, nums2);
    }
    
    private int[] intersectByCounting(int[] nums1, int[] nums2) {
        int[] counts1 = countNums(nums1);
        int[] counts2 = countNums(nums2);
        List<Integer> intersection = new ArrayList<>();
        for (int num=0; num<=MAX_NUM; num++) {
            int count = Math.min(counts1[num], counts2[num]);
            for (; count>0; count--) {
                intersection.add(num);
            }
        }
        return intersection.stream().mapToInt(i->i).toArray();
    }
    
    private int[] countNums(int[] nums) {
        int[] counts = new int[MAX_NUM+1];
        for (int num : nums) {
            counts[num]++;
        }
        return counts;
    }
    
    private int[] intersectBySorting(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersection = new ArrayList<>();
        final int[] shorter = nums1.length<nums2.length ? nums1 : nums2;
        final int[] longer = shorter==nums1 ? nums2 : nums1;
        int shorterIndex = 0;
        while (shorterIndex<shorter.length) {
            int longerIndex = Arrays.binarySearch(longer, shorter[shorterIndex]);
            if (longerIndex >= 0) {
                while (longerIndex>0 && longer[longerIndex]==longer[longerIndex-1]) {
                    longerIndex--;
                }
                while (shorterIndex<shorter.length 
                       && longerIndex<longer.length 
                       && shorter[shorterIndex]==longer[longerIndex]) {
                    intersection.add(shorter[shorterIndex]);
                    shorterIndex++;
                    longerIndex++;
                }
                while (shorterIndex<shorter.length 
                       && shorter[shorterIndex]==shorter[shorterIndex-1]) {
                    shorterIndex++;
                }
            } else {
                shorterIndex++;
            }
        }
        return intersection.stream().mapToInt(i->i).toArray();
    }
}
