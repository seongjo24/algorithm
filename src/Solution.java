class Solution {
    static final int SIZE = 101;
    static boolean[][] board = new boolean[SIZE][SIZE]; // true: 점

    int[] dR = new int[]{-1, 1, 0, 0};
    int[] dC = new int[]{0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int srcRow = characterY * 2;
        int srcCol = characterX * 2;
        int dstRow = itemY * 2;
        int dstCol = itemX * 2;

        markRect(rectangle);


        int totalDistance = findDistance(srcRow, srcCol, srcRow, srcCol, new boolean[SIZE][SIZE], 0) + 1;
        int distance = findDistance(srcRow, srcCol, dstRow, dstCol, new boolean[SIZE][SIZE], 0);

        return Math.min(distance, totalDistance - distance) / 2;
    }

    private void markRect(int[][] rectangles) {
        for (int[] rect: rectangles) {
            int firstRow = 2* rect[1];
            int firstCol = 2* rect[0];
            int secondRow = 2* rect[3];
            int secondCol = 2* rect[2];

            markEdge(firstRow, firstCol, secondRow, secondCol);
        }

        for (int[] rect: rectangles) {
            int firstRow = 2* rect[1];
            int firstCol = 2* rect[0];
            int secondRow = 2* rect[3];
            int secondCol = 2* rect[2];

            markSpace(firstRow, firstCol, secondRow, secondCol);
        }
    }


    private void markEdge(int firstRow, int firstCol, int secondRow, int secondCol) {
        for(int row = firstRow; row <= secondRow; row++) {
            board[row][firstCol] = true;
        }
        for(int col = firstCol + 1; col <= secondCol; col++) {
            board[secondRow][col] = true;
        }
        for(int row = secondRow - 1; row >= firstRow; row--) {
            board[row][secondCol] = true;
        }
        for (int col = secondCol - 1; col > firstCol; col--) {
            board[firstRow][col] = true;
        }
    }


    private void markSpace(int firstRow, int firstCol, int secondRow, int secondCol) {
        for (int row = firstRow + 1; row < secondRow; row++) {
            for (int col = firstCol + 1; col < secondCol; col++) {
                board[row][col] = false;
            }
        }
    }


    private int findDistance(int row, int col, final int dstRow, final int dstCol, final boolean[][] visited, int count) {
        if (count > 0 && row == dstRow && col == dstCol) {
            return count;
        }

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dR[i];
            int newCol = col + dC[i];

            if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE && board[newRow][newCol] && !visited[newRow][newCol]) {
                return findDistance(newRow, newCol, dstRow, dstCol, visited, count+1);
            }
        }

        return count;
    }
}