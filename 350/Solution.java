class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        final List<Integer> intersection = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
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
        final int[] intersectionArray = new int[intersection.size()];
        int i = 0;
        for (final int num : intersection) {
            intersectionArray[i++] = num;
        }
        return intersectionArray;
    }
}
