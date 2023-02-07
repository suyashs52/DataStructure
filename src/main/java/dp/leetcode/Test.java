package dp.leetcode;

import java.util.*;

public class Test {

    public static void main(String[] args) {

//        System.out.println(maxCount(new int[]{1,6,5},5,6));
//        System.out.println(maxCount(new int[]{1,2,3,4,5,6,7},8,1));
//        System.out.println(maxCount(new int[]{11},7,50));

//        System.out.println(isPossibleToCutPath(new int[][]{
//                {1,1,1},
//                {1,0,0},
//                {1,1,1}
//        }));
//        System.out.println(isPossibleToCutPath(new int[][]{
//                {1,1,1},
//                {1,0,1},
//                {1,1,1}
//        }));
//        System.out.println(isPossibleToCutPath(new int[][]{
//                {1,1,1},
//
//        }));
//        System.out.println(isPossibleToCutPath(new int[][]{
//                {1,1},
//
//        }));
//        System.out.println(isPossibleToCutPath(new int[][]{
//                {1,0},
//                {1,1}
//
//        }));
        System.out.println(isPossibleToCutPath(new int[][]{
                {1,1,1,0,0},
                {1,0,1,0,0},
                {1,1,1,1,1},
                {0,0,1,1,1},

        }));

    }

   static int count=0;
    public static boolean isPossibleToCutPath(int[][] grid) {
        int[][] visited =new int[grid.length][grid[0].length];
       if(grid.length==1 ){
           if( grid[0].length<3) return  false;
           return true;
       }
        if(grid[0].length==1 ){
            if( grid.length<3) return  false;
            return true;
        }

      //  int[][] directtion=new int[][]{{0,1},{1,0}}; //right , down
        count=0;
        dfs(grid,0,0,grid.length-1,grid[0].length-1,visited);
        if(count==1) return true;
        return false;
    }

    private static  void dfs( int[][] grid,int row,int col,int trow,int tcol,int[][] visited) {
        if(row==trow && tcol==col){
            count++;
            return;
        }

        if(count>1) return;
        if(row <0 || row>trow) return;
        if(col<0 || col>tcol) return;
        if(grid[row][col]==0) return;
        if(visited[row][col]==1) return;
        if(row==0 && col==0){
            visited[row][col]=0;
        }else {
            visited[row][col]=1;
        }

        dfs(grid,row,col+1,trow,tcol,visited);
        dfs(grid,row+1,col,trow,tcol,visited);





    }


    public static int maxCount(int[] banned, int n, int maxSum) {
        int ans=0;

        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        if(maxSum==1) return  0;
        for(int i:banned){
            set.add(i);
        }
        for(int i=1;i<n+1;i++){
            if(maxSum==0) break;
            if(set.contains(i)){

            }else if(i>maxSum){
                return ans;

            }
            else {
              maxSum=  maxSum-i;
              ans++;
            }
        }
        return ans;
    }
}
