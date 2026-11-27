class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        while (!q.isEmpty()) {
            Pair front = q.remove();
            int row = front.row, col = front.col;
            if (row > 0) {
                if (visited[row - 1][col] == false && grid[row - 1][col] == '1') {
                    q.add(new Pair(row - 1, col));
                    visited[row - 1][col] = true;
                }
            }
            if ((row+1) < m) {
                if (visited[row + 1][col] == false && grid[row + 1][col] == '1') {
                    q.add(new Pair(row + 1, col));
                    visited[row + 1][col] = true;
                }

            }
            if (col > 0) {
                if (visited[row][col - 1] == false && grid[row][col - 1] == '1') {
                    q.add(new Pair(row, col - 1));
                    visited[row][col - 1] = true;
                }
            }
            if ((col+1) < n) {
                if (visited[row][col + 1] == false && grid[row][col + 1] == '1') {
                    q.add(new Pair(row, col + 1));
                    visited[row][col + 1] = true;

                }
            }

        }

    }

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }
}