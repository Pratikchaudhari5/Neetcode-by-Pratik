// ========================== // Brute force // ==================== //
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // for row
        for(int row = 0; row<9 ; row++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i<9; i++){
                if(board[row][i]== '.') continue;
            if(seen.contains(board[row][i])) return false;
            seen.add(board[row][i]);
            }
        }
        //for col
        for(int col = 0; col<9; col++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i<9 ; i++){
                if(board[col][i] == '.') continue;
                if(seen.contains(board[col][i])) return false;
                seen.add(board[col][i]);
            }
        }
        //for 3/3 sqaure
        for(int sq = 0; sq< 9; sq++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                      int row = (sq / 3) * 3 + i;
                    int col = (sq % 3) * 3 + j;
                    if(board[row][col] == '.') continue;
                    if(seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
//TC: O(n^2)
//SC: O(n^2)

// ========================== // Optimized // ==================== //
