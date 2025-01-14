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
//Time Complexity: 𝑂(1)
//O(1) (Fixed board size of 9x9).
//Space Complexity: 𝑂(1)
//O(1) (Fixed board size limits HashSet entries).
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // HashSet to store strings that represent already-seen digits in rows, columns, and sub-boxes
        HashSet<String> seen = new HashSet<>();

        // Iterate through each cell in the 9x9 board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currVal = board[i][j]; // Get the current cell value
                
                // If the current cell is not empty ('.'), check its validity
                if (currVal != '.') {
                    // Try to add unique identifiers to the HashSet for rows, columns, and sub-boxes
                    // If any of these fails (already exists in the set), return false
                    if (
                        !seen.add(currVal + " found in row " + i) ||       // Check row
                        !seen.add(currVal + " found in col " + j) ||       // Check column
                        !seen.add(currVal + " found in sub box " + i / 3 + "-" + j / 3) // Check sub-box
                    ) {
                        return false; // If duplicate is found, the board is invalid
                    }
                }
            }
        }

        return true; // If no duplicates are found, the board is valid
    }
}

