class Solution {
    
    private static int DECREASING = -1;
    private static int INCREASING = 1;
    
    public boolean validMountainArray(int[] arr) {
        if (arr.length<3) {
            return false;
        }
        if (arr[0] >= arr[1]) {
            return false;
        }
        int state = INCREASING;
        for (int i=2; i<arr.length; i++) {
            if (state == INCREASING) {
                if (arr[i] == arr[i-1]) {
                    return false;
                }
                if (arr[i] < arr[i-1]) {
                    state = DECREASING;
                }   
            } else {
                if (arr[i] >= arr[i-1]) {
                    return false;
                }
            }
        }
        return state == DECREASING;
    }
}
