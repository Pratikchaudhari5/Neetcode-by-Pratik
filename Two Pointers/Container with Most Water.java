// ============================ // Brute Force // ========================== //
//TC: O(n^2) for two loops
//SC: O(1)
// use two loops and use area formula cal height then width then area
class Solution {
    public int maxArea(int[] height) {
        int res= 0;
        for(int i = 0; i<height.length; i++){
            for(int j = i+1; j<height.length; j++){
                res = Math.max(res,Math.min(height[i],height[j]) * [j-i]);
                // height[i],height[j] = take min height
                // [j - i] = take witdth 
                // Area = height * width 
            }

        }
        return res;
    }
}
// ============================ // Two Pointer // ========================== //
//TC: O(n) for while loop
//SC: O(1)
// use two pointer then use area formula
class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;

        while(l<r){
            int Area = Math.min(height[l],height[r]) * (r - l);
            // Area  =     height  * width
            res = Math.max(res,Area); 
            if(height[l]<= height[r]){
                l++;
            }else {
                r--;
            }
        }
        return res;
    }
}
