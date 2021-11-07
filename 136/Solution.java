class Solution {
    public int singleNumber(int[] nums) {
        int singledOutNum = 0;
        for (int num : nums) {
            singledOutNum = singledOutNum ^ num;
        }
        return singledOutNum;
    }
}