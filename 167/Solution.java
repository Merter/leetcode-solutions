class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int smallIndex = 0;
        int bigIndex = numbers.length-1;
        while (true) {
            int sum = numbers[smallIndex] + numbers[bigIndex];
            if (sum == target) {
                return new int[]{smallIndex+1, bigIndex+1};
            }
            if (sum < target) {
                smallIndex++;
            } else {
                bigIndex--;
            }
        }
    }

    public int[] twoSumWithBinarySearch(int[] numbers, int target) {
        for (int i=0; i<numbers.length; i++) {
            int counterPart = target-numbers[i];
            int counterPartIndex = binarySearchInRangeInclusive(numbers, counterPart, i+1, numbers.length-1);
            if (counterPartIndex == -1) {
                continue;
            }
            return new int[] {i+1, counterPartIndex+1};
        }
        return new int[] {0, 0};
    }
    
    private int binarySearchInRangeInclusive(int[] sortedNumbers, int target, int begin, int end) {
        while (true) {
            if (begin > end) { 
                return -1;
            }
            if (begin == end) {
                return sortedNumbers[begin]==target ? begin : -1;
            }
            int mid = begin + (end-begin)/2;
            if (sortedNumbers[mid] == target) {
                return mid;
            }
            if (sortedNumbers[mid] < target) {
                begin = mid+1;
            } else {
                end=mid-1;
            }
        }
    }
}
