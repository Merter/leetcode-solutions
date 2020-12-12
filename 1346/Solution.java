class Solution {
    public boolean checkIfExist(int[] nums) {
        Set<Integer> doubles = new HashSet<>();
        for (int num : nums) {
            if (num == 0) {
                if (doubles.contains(0)) {
                    return true;
                }
            }
            if (num%2==0) {
                doubles.add(num);
            }
        }
        for (int num : nums) {
            if (num!=0 && doubles.contains(num*2)) {
                return true;
            }
        }
        return false;
    }
}
