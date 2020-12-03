class MapSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> num2Indices = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            List<Integer> indices = num2Indices.get(nums[i]);
            if (indices == null) {
                indices = new ArrayList<>();
            }
            indices.add(i);
            num2Indices.put(nums[i], indices);
        }
        for (Map.Entry<Integer, List<Integer>> entry : num2Indices.entrySet()) {
            int counterPartKey = target-entry.getKey();
            List<Integer> indices = entry.getValue();
            List<Integer> counterPartIndices = num2Indices.get(counterPartKey);
            if (counterPartIndices == null) {
                continue;
            }
            if (indices == counterPartIndices) {
                if (indices.size() == 1) {
                    continue;
                }
                return new int[]{indices.get(0), indices.get(1)};
            }
            return new int[]{indices.get(0), counterPartIndices.get(0)};
        }
        return new int[] {-1, -1};
    }
}