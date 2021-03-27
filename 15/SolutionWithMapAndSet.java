class SolutionWithMapAndSet {
    public List<List<Integer>> threeSum(int[] nums) {
        final Map<Integer, Integer> uniqueNums = new HashMap<>();
        for (int num : nums) {
            Integer count = uniqueNums.get(num);
            if (count == null) {
                uniqueNums.put(num, 1);
            } else {
                uniqueNums.put(num, count+1);
            }
        }
        final Set<List<Integer>> sum3UniqueResults = new HashSet<>();
        for (int firstNum : uniqueNums.keySet()) {
            Integer firstNumCount = uniqueNums.get(firstNum);
            uniqueNums.put(firstNum, firstNumCount-1);
            for (int secondNum : uniqueNums.keySet()) {
                Integer secondNumCount = uniqueNums.get(secondNum);
                if (secondNumCount == 0) { 
                    continue;
                }
                uniqueNums.put(secondNum, secondNumCount-1);
                final int thirdNum = 0-firstNum-secondNum;
                Integer thirdNumCount = uniqueNums.get(thirdNum);
                if (thirdNumCount==null || thirdNumCount==0) {
                    uniqueNums.put(secondNum, secondNumCount);
                    continue;
                }
                final List<Integer> trio = new ArrayList<>(3);
                trio.add(firstNum);
                trio.add(secondNum);
                trio.add(thirdNum);
                Collections.sort(trio);
                sum3UniqueResults.add(trio);
                uniqueNums.put(secondNum, secondNumCount);
            }
            uniqueNums.put(firstNum, firstNumCount);
        }
        final List<List<Integer>> sum3Results = new ArrayList<>(sum3UniqueResults);
        return sum3Results;
    }
}