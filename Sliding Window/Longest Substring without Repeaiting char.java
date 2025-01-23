// Approach : two loops start from 0 , hashset, add ele if not present , get max size
// T.C : O(n*m)
//S.C : O(m)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for(int i = 0; i<s.length(); i++){
                    Set<Character> h = new HashSet<>();
            for(int j = i ; j<s.length(); j++){
                if(h.contains(s.charAt(j))){
                    break;
                }
                h.add(s.charAt(j));
            }
            res = Math.max(res,h.size());
        }
        return res;
    }
}
// ======================= // Optimized - slidng window // =================== //
// Appraoch : put l and r at 0 , create set, iterate r, if contains r , remove l , l++, else add r in h, resturn max res
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int res = 0;
Set<Character> h = new HashSet<>();
        for(int r = 0; r<s.length(); r++){
            while(h.contains(s.charAt(r))){
                h.remove(s.charAt(l));
                l++;
            }
            h.add(s.charAt(r));
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
