class Solution {
    public String multiply(final String num1, final String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num1.equals("1")) {
            return num2;
        }
        if (num2.equals("1")) {
            return num1;
        }
        final String longer = num1.length() > num2.length() ? num1 : num2;
        final String shorter = num1.equals(longer) ? num2 : num1;
        final LinkedList<List<Integer>> digitIndexedIntegersToBeSummed = new LinkedList<>();
        for (int shortIndex=shorter.length()-1; shortIndex>=0; shortIndex--) {
            final int multiplier = Character.getNumericValue(shorter.charAt(shortIndex));
            if (shorter.length()-shortIndex > digitIndexedIntegersToBeSummed.size()) {
                digitIndexedIntegersToBeSummed.addLast(new ArrayList<>());
            }
            if (multiplier == 0) {
                continue;
            }
            int carry = 0;
            for (int longIndex=longer.length()-1; longIndex>=0; longIndex--) {
                final int multiplicand = Character.getNumericValue(longer.charAt(longIndex));
                int result = multiplier * multiplicand + carry;
                carry = result / 10;
                result = result % 10;
                final int toBeSummedIndex = shorter.length()-shortIndex-1+longer.length()-longIndex-1;
                if (digitIndexedIntegersToBeSummed.size()-1 < toBeSummedIndex) {
                    digitIndexedIntegersToBeSummed.addLast(new ArrayList<>());
                }
                final List<Integer> toBeSummed = digitIndexedIntegersToBeSummed.get(toBeSummedIndex);
                toBeSummed.add(result);
            }
            if (carry > 0) {
                final int toBeSummedIndex = shorter.length()-shortIndex+longer.length()-1;
                if (digitIndexedIntegersToBeSummed.size()-1 < toBeSummedIndex) {
                    digitIndexedIntegersToBeSummed.addLast(new ArrayList<>());
                }
                final List<Integer> toBeSummed = digitIndexedIntegersToBeSummed.get(toBeSummedIndex);
                toBeSummed.add(carry);
            }
        }
        return constructSum(digitIndexedIntegersToBeSummed);
    }
    
    private String constructSum(final LinkedList<List<Integer>> digitIndexedIntegersToBeSummed) {
        final StringBuilder stb = new StringBuilder();
        int carry = 0;
        while (! digitIndexedIntegersToBeSummed.isEmpty()) {
            final List<Integer> nums = digitIndexedIntegersToBeSummed.removeFirst();
            int sum = carry;
            for (final int num : nums) {
                sum += num;
            }
            carry = sum / 10;
            sum = sum % 10;
            stb.append(sum);
        }
        if (carry > 0) {
            stb.append(carry);
        }
        stb.reverse();
        return stb.toString();
    }
}
