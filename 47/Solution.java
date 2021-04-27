class Solution {
    
    private static int DELETED_MARK = -15;  // since -15 cannot be a valid num
    
    public List<List<Integer>> permuteUnique(final int[] nums) {
        final List<List<Integer>> perms = permute(nums);
        final Set<List<Integer>> uniquePerms = new HashSet<>(perms);
        return new ArrayList<List<Integer>>(uniquePerms);
    }
    
    private List<List<Integer>> permute(final int[] nums) {
        boolean allDeleted = true;
        List<List<Integer>> perms = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == DELETED_MARK) {
                continue;
            }
            allDeleted = false;
            final int originalValue = nums[i];
            nums[i] = DELETED_MARK;
            List<List<Integer>> subPerms = permute(nums);
            for (List<Integer> subPerm : subPerms) {
                subPerm.add(originalValue);
                perms.add(subPerm);
            }
            nums[i] = originalValue;
        }
        if (allDeleted) {
            perms.add(new ArrayList<>());
        }
        return perms;
    }
}
