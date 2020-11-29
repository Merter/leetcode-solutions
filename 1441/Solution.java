class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int targetPos = 0;
        for (int i=1; i<=n; i++) {
            if (targetPos == target.length) {
                break;
            }
            if (target[targetPos] == i) {
                operations.add("Push");
                targetPos++;
            } else {
                operations.add("Push");
                operations.add("Pop");
            }
        }
        return operations;
    }
}
