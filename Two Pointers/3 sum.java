// ============================ // Brute Force // ================================ //
// TC: O(n^3)
//SC: O(m)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Set<List<Integer>> res= new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length ;j++){
                for(int k = j+1; k<nums.length ;k++){
                    if(nums[i]+ nums[j]+nums[k] == 0){
                        List<Integer> tmp = Arrays.asList(nums[i],nums[j],nums[k]);
                        res.add(tmp);
                    } 
                }
            }
        }
        return new ArrayList<>(res);
    }
} // TLE error
// ====================== // TWO POINTER // ============ //
// create res to store ans, use formula n1+ n2 + n3 = 0 i.e. n2 + n3 = -n1
//  sort array first , fix n1 by for loop skip duplicate then apply two sum
// check if i and j are same then skip duplicate and add in res 
//TC: O(n^2)
//SC: O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // if array size is less than 3 return nothing
        if(nums.length < 3){
            return new ArrayList<>();
        }
        //store result here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // sort it
        // n1 + n2 + n3 = 0; i.e. n2 + n3 = -n1
        // fix n1
        for(int i = 0; i<nums.length; i++){
            //if duplicate skip it
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            twoSum(nums,i+1, res, -nums[i]); // -n1 = -nums[i]
        }
        return res;
    }
    private void twoSum(int [] nums, int k , List<List<Integer>> res, int target){
        int i = k, j = nums.length - 1;
        while(i<j){
            if(nums[i]+nums[j] == target){
                res.add(Arrays.asList(-target,nums[i],nums[j]));
                //duplicate skip
                while(i<j && nums[i] == nums[i+1]){
                    i++;
                }
                while(i<j && nums[j] == nums[j-1]){
                    j--;
                }
                i++;
                j--;
            }
            else if(nums[i]+nums[j]<target){
                i++;
            }else {
                j--;
            }
        }
    }
}
