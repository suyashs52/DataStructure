package dp.graph;

public class FarLand01 {
    //https://leetcode.com/problems/as-far-from-land-as-possible/
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1},

        }));
    }

    public static int maxDistance(int[][] grid) {

        //from top left navigate and add cell distance

        int[][] direction = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; //move right down up left

        //from top left iterate
        int row = grid.length;
        int col = grid[0].length;
        int maxdis = row + col + 1; //max distance ll always be from 00 to n-1n-1 in diagonal m+n for a diagonal 2 one right one down
        //from top left start populating consider left,top value
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = maxdis;

                    if (i > 0) {
                        //row is not 0
                        grid[i][j] = Math.min(grid[i - 1][j]+1, grid[i][j]); //take from prev row : top
                    }
                    if (j > 0) {
                        grid[i][j] = Math.min(grid[i][j - 1]+1, grid[i][j]); //take from prev col : left
                    }


                }


            }
        }
        int ans = -1;
        //from bottom right start populating consider right,bottom value

        for (int i = row - 1; i > -1; i--) {
            for (int j = col - 1; j > -1; j--) {


                if (i < row - 1) {
                    //row is not 0
                    grid[i][j] = Math.min(grid[i + 1][j]+1, grid[i][j]); //take from next row : bottom
                }
                if (j < col - 1) {
                    grid[i][j] = Math.min(grid[i][j + 1]+1, grid[i][j]); //take from next col : right
                }
                ans = Math.max(ans, grid[i][j]);

            }


        }

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(grid[i][j]);
//            }
//            System.out.println();
//        }

        if (ans == 0 || ans == maxdis) {
            return -1;
        }
        return ans;


    }

    public static int maxDistance1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] direction = new int[][]{{0, 1}, {-1, 0}};
        int[][] dir = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        int zero = 0;
        int one = 0;
        for (int i = 0; i < m; i++) { //row
            for (int j = 0; j < n; j++) { //col
                int val = 0;
                // if(visited[i][j]) continue;
                if (grid[i][j] == 0) {
                    dir[i][j] = Math.max(dir[i][j], 1);
                    zero++;
                } else {
                    one++;
                }
                visited[i][j] = true;

                for (int k = 0; k < 2; k++) {
                    int row = i + direction[k][0];
                    int col = j + direction[k][1];
                    if (row > -1 && row < m && col > -1 && col < n && grid[row][col] == 0
                            && !visited[row][col]) {
                        dir[row][col] = Math.min(dir[row][col], dir[i][j] + 1);
                        // max=Math.max(max,dir[row][col]);
                    }
                }

            }
        }

        if (one == 0 || zero == 0) return -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dir[i][j] + " ");
            }
            System.out.println();
        }

        return max;


    }
}
