class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        return selfDividingNumbersInPlace(left, right);
    }

    private List<Integer> selfDividingNumbersInPlace(int left, int right) {
        List<Integer> selfDividingNumbers = new ArrayList<>();
        for (int num=left; num<=right; num++) {
            int numDigits = num;
            boolean add = true;
            while (numDigits != 0) {
                int digit = numDigits % 10;
                if (digit == 0) {
                    add = false;
                    break;
                }
                if (num%digit != 0) {
                    add = false;
                    break;
                }
                numDigits /= 10;
            }
            if (add) {
                selfDividingNumbers.add(num);
            }        
        }
        return selfDividingNumbers;
    }

    private List<Integer> selfDividingNumbersWithDigitListCalculation(int left, int right) {
        List<Integer> selfDividingNumbers = new ArrayList<>();
        for (int num=left; num<=right; num++) {
            if (Solution.isSelfDividingNumber(num)) {
                selfDividingNumbers.add(num);
            }
        }
        return selfDividingNumbers;
    }
    
    private static boolean isSelfDividingNumber(int num) {
        List<Integer> digits = Solution.digitsOf(num);
        for (int digit : digits) {
            if (digit == 0) return false;
            if (num%digit != 0) return false;
        }
        return true;
    }
    
    private static List<Integer> digitsOf(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }
}
