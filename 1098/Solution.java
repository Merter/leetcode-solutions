class Solution {
    public void duplicateZeros(final int[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (arr[index] != 0) {
                index++;
                continue;
            }
            index++;
            if (index == arr.length) {
                return;
            }
            int curr = arr[index];
            arr[index] = 0;
            index++;
            for (int shiftIndex = index; shiftIndex<arr.length; shiftIndex++) {
                final int temp = arr[shiftIndex];
                arr[shiftIndex] = curr;
                curr = temp;
            }
        }
    }
}
