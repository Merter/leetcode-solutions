class Solution {
    
    final static int DECREASING = -1;
    final static int FLAT = 0;
    final static int INCREASING = 1;
    
    public int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        boolean isMountain = false;
        int maxMountainLength = 0;
        int currMountainLength = 0;
        int state = 0;
        if (arr[0] < arr[1]) {
            if (arr[1] < arr[2]) {
                // 0 1 2... possible mountain start
                currMountainLength = 3;
                state = INCREASING;
            } else if (arr[1] > arr[2]) {
                // 0 1 0... real mountain
                isMountain = true;
                state = DECREASING;                
                currMountainLength = 3;
            } else {
                // 0 1 1
                currMountainLength = 1;
                state = FLAT;
            }
        } else if (arr[0] == arr[1]) {
            if (arr[1] == arr[2]) {
                currMountainLength = 1;
                state = FLAT;
            } else if (arr[1] < arr[2]) {
                currMountainLength = 2;
                state = INCREASING;
            } else {
                currMountainLength = 1;
                state = DECREASING;
            }
        } else {
            // 2 1 ...
            if (arr[1] == arr[2]) {
                currMountainLength = 1;
                state = FLAT;
            } else if (arr[1] > arr[2]) {
                // 2 0 0... or 2 1 0... or 2 2 2... no mountain yet
                currMountainLength = 1;
                state = DECREASING;
            } else {
                // 2 2 3... or 2 1 2... possible mountain start
                currMountainLength = 2;
                state = INCREASING;
            }
        }
        for (int i=3; i<arr.length; i++) {
            if (arr[i-1] < arr[i]) {                
                if (state != INCREASING) {
                    if (isMountain && currMountainLength>maxMountainLength) {
                        maxMountainLength = currMountainLength;
                    }
                    isMountain = false;                    
                    currMountainLength = 2;                    
                    state = INCREASING;
                } else {
                    currMountainLength++;
                }
            } else if (arr[i-1] == arr[i]) {
                if (isMountain && currMountainLength>maxMountainLength) {
                    maxMountainLength = currMountainLength;
                }
                isMountain = false;
                currMountainLength = 1;
                state = FLAT;
            } else {
                if (state == INCREASING) {
                    isMountain = true;
                } else if (state == FLAT) {
                    isMountain = false;
                }
                state = DECREASING;                
                currMountainLength++;                
            }
        }
        if (isMountain && currMountainLength>maxMountainLength && state==DECREASING) {
            maxMountainLength = currMountainLength;
        }
        return maxMountainLength;
    }
}