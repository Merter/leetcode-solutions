class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int num : target) {
            Integer count = num2Count.get(num);
            if (count == null) {
                count = 0;
            }
            num2Count.put(num, ++count);
        }
        for (int num : arr) {
            Integer count = num2Count.get(num);
            if (count == null) {
                return false;
            }
            --count;
            if (count == 0) {
                num2Count.remove(num);
            } else {
                num2Count.put(num, count);
            }
        }
        return true;
    }

    public boolean canBeEqualUsingCanonicalForm(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
