//Appraoch : create left right array then fill them with max height at last use formula
// formula : ans += min(left[i],right[i]) - height[i]
//T.C : O(3N) i.e O(N)
//S.C : O(2N) two array i.e. O(N)
class Solution {
    public int trap(int[] height) {
        int n = height.length; 
        
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = height[0];
        for(int i= 1; i<n; i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        right[n - 1] = height[n - 1];
        for(int i = n - 2; i>=0; i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans += Math.min(left[i],right[i]) - height[i];
        }
        return ans;
    }
}
