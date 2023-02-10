package dp.leetcode;

public class JumpGame2 {
    //https://leetcode.com/problems/jump-game-ii/

    public static void main(String[] args) {
   //     System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
    }

    public static int jump(int[] nums) {

        int[] minmove = new int[nums.length ];

        minmove[nums.length-1] = 0; //reaching n from n is 0 min move
        if (nums.length < 2) return 0;
        if (nums.length < 3) return 1;
        int n = nums.length;
        for (int i = nums.length - 2; i > -1; i--) {
            int tmove = n;
            int m=nums[i];
            int mins=100000;
            for(int j=i+1;j<=i+m && j<n ;j++){
                mins=Math.min(mins,minmove[j]+1);


            }
            minmove[i]=mins;
        }
            return minmove[0];
    }
}
