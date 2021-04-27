class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<Integer>();
        for (int num : nums) {
            uniqueNums.add(num);
        }
        return permute(uniqueNums);
    }
    
    private List<List<Integer>> permute(Set<Integer> nums) {
        List<List<Integer>> perms = new ArrayList<>();
        if (nums.isEmpty()) {
            perms.add(new ArrayList<>());
            return perms;
        }
        Set<Integer> subNums = new HashSet<>(nums);
        for (int num : nums) {
            subNums.remove(num);
            List<List<Integer>> subPerms = permute(subNums);
            for (List<Integer> subPerm : subPerms) {
                subPerm.add(num);
                perms.add(subPerm);
            }
            subNums.add(num);
        }
        return perms;
    }
}
