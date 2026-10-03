class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Integer bitmasks for 9 rows, 9 columns, and 9 sub-boxes
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.') {
                    continue;
                }

                // Digit '1'-'9' mapped to bit position 0-8
                int valBit = 1 << (val - '1');
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Check if the bit is already set in row, col, or box
                if ((rows[r] & valBit) != 0 || 
                    (cols[c] & valBit) != 0 || 
                    (boxes[boxIndex] & valBit) != 0) {
                    return false;
                }

                // Set the bit in row, col, and box
                rows[r] |= valBit;
                cols[c] |= valBit;
                boxes[boxIndex] |= valBit;
            }
        }

        return true;
    }
}