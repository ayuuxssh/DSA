class Solution {
    int n;
    int mod = (int) 1e9 + 7;
    int[][] dp;
    int[][][] dp1;

    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();
        dp = new int[n][n];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        char[][] c = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = board.get(i).charAt(j);
                // System.out.println(c[i][j]);
            }
        }

        int ans = sum(c, n - 1, n - 1);
        if (ans < 0) {
            return new int[] { 0, 0 };
        } else {
            dp1 = new int[n][n][ans + 1];
            for (int[][] it : dp1) {
                for (int[] it1 : it) {
                    Arrays.fill(it1, -1);
                }
            }
            int ans1 = count(c, n - 1, n - 1, ans) % mod;
            return new int[] { ans, ans1 };
        }

    }

    private int sum(char[][] board, int i, int j) {
        if (i == 0 && j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = Integer.MIN_VALUE;
        int up = Integer.MIN_VALUE;
        int upleft = Integer.MIN_VALUE;
        if (i == n - 1 && j == n - 1) {
            if (board[i][j - 1] != 'X') {
                left = sum(board, i, j - 1);
            }
            if (board[i - 1][j] != 'X') {
                up = sum(board, i - 1, j);
            }
            if (board[i - 1][j - 1] != 'X') {
                upleft = sum(board, i - 1, j - 1);
            }
        } else {
            if (j > 0) {
                if (board[i][j - 1] != 'X') {
                    left = (board[i][j] - '0') + sum(board, i, j - 1);
                }
            }
            if (i > 0) {
                if (board[i - 1][j] != 'X') {
                    up = (board[i][j] - '0') + sum(board, i - 1, j);
                }
            }
            if (i > 0 && j > 0) {
                if (board[i - 1][j - 1] != 'X') {
                    upleft = (board[i][j] - '0') + sum(board, i - 1, j - 1);
                }
            }
        }
        // System.out.println(Math.max(left,Math.max(up,upleft)));
        return dp[i][j] = Math.max(left, Math.max(up, upleft));
    }

    private int count(char[][] board, int i, int j, int target) {
        if (target < 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        if (dp1[i][j][target] != -1) {
            return dp1[i][j][target];
        }
        int left = 0;
        int up = 0;
        int upleft = 0;
        if (i == n - 1 && j == n - 1) {
            if (board[i][j - 1] != 'X') {
                left = count(board, i, j - 1, target);
            }
            if (board[i - 1][j] != 'X') {
                up = count(board, i - 1, j, target);
            }
            if (board[i - 1][j - 1] != 'X') {
                upleft = count(board, i - 1, j - 1, target);
            }
        } else {
            if (j > 0) {
                if (board[i][j - 1] != 'X') {
                    left = count(board, i, j - 1, target - (board[i][j] - '0'));
                }
            }
            if (i > 0) {
                if (board[i - 1][j] != 'X') {
                    up = count(board, i - 1, j, target - (board[i][j] - '0'));
                }
            }
            if (i > 0 && j > 0) {
                if (board[i - 1][j - 1] != 'X') {
                    upleft = count(board, i - 1, j - 1, target - (board[i][j] - '0'));
                }
            }
        }
        // System.out.println(Math.max(left,Math.max(up,upleft)));
        return dp1[i][j][target] = ((left + up) % mod + upleft) % mod;
    }
}