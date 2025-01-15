// ================================== // Brtue Force // ============================ //
//TC: O(n^2)
//SC: O(n)
public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> store = new HashSet<>();
        for (int num : nums) {
            store.add(num);
        }

        for (int num : nums) {
            int streak = 0, curr = num;
            while (store.contains(curr)) {
                streak++;
                curr++;
            }
            res = Math.max(res, streak);
        }
        return res;
    }
}
// ================================== //Optimized // ============================ //
//TC: O(n)
//SC: O(n)
// Hashset - add ele - check left side ele present or not - if no then - length is 1 and check num + length store in longest - return longest
class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> store = new HashSet<>();
        for(int num : nums){
            store.add(num);
        }
        int longest = 0;
        for(int num : store){
            if(!store.contains(num-1)){
                int length = 1;
                while(store.contains(num + length)){
                    length++;
                }
                longest = Math.max(longest, length);
            }
            
        }
        return longest;
    }
}
