class Solution {
    public int findNumbers(final int[] nums) {
        int evenDigitNumCount = 0;
        for (final int num : nums) {
            if (digitCount(num)%2 == 0) {
                evenDigitNumCount++;
            }
        }
        return evenDigitNumCount;
    }
    
    private int digitCount(final int num) {
        return (int)Math.floor(Math.log10(num)) + 1;
    }
}
