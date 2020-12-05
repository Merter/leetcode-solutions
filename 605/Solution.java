class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0){
            return true;
        }
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0;    
        }
        if (n == flowerbed.length) {
            return false;
        }
        if (flowerbed.length == 2) {
            return n==1 && flowerbed[0]==0 && flowerbed[1]==0;
        }
        if (flowerbed[0]==0 && flowerbed[1]==0) {
            flowerbed[0] = 1;
            n--;
        }
        int i = 1;
        while (n > 0) {
            if (i == flowerbed.length) {
                return false;
            }
            if (flowerbed[i-1]==0 && flowerbed[i]==0) {
                if ((i+1==flowerbed.length) || (flowerbed[i+1]==0)) {
                    flowerbed[i] = 1;
                    n--;
                }         
            }
            i++;
        }
        return true;        
    }
}
