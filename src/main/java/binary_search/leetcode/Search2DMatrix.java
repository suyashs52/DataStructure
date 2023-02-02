package binary_search.leetcode;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix=new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(matrix,3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean found=false;

        int m=matrix.length;
        int n=matrix[0].length;

        int size=m*n-1;
        //row m is =size/n
        //col  is size%n ex 3*4 =12 , 10th is 10/4 2 row 10%2 2 col so from 0-11 2nd last
        int start=0;
        int end=size;

        while (start<=end){
            int mid=start+(end-start)/2;

            int val=matrix[mid/n][mid%n];

            if(val==target){
                return true;
            }
            else if(val<target){
                start=mid+1;
            }else {
                end=mid-1;
            }


        }


        return found;
    }
}
