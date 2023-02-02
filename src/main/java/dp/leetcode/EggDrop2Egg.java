package dp.leetcode;

public class EggDrop2Egg {
    public static void main(String[] args) {

        System.out.println(twoEggDrop(100));
    }

    public static int twoEggDrop(int n) {
        //best solution is divide n is such a partition that each next partition ll be 1 less then current parition
        //so if egg not break we need to test in parition of less size and we are coverting all and have min move
        //so k + k-1 + k-2 +..1=n => k*(k+1)/2=n k2+k-2n=0 so quadratic equation solution -b+sqrt(b2-4ac)/2
        //k= a=1 c=-2 b=1

        return (int) Math.ceil(((-1 + Math.sqrt(1 + 8 * n)) / 2.0));
    }

    public static int twoEggDrop1(int n) {

        //egg can either break or survive, if egg break at floor j need to test from 1..j-1 floor to test which floor
        // has the issue so total is 1+(j-1) if it not break at jth floor means 1+ let try same thing from j+1 to kth floor
        //return the minimum move so take minium of both (break , not break)
        //solving a problem again and agian so dp question
        //ex : floor 3 minimum move would be try at floor 2 if not break check at 3 so total min move is 2
        //if egg break at 2 then try at 1 so again min move is 2
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2; //if it breaks at 2nd then try from 1st

        for (int i = 3; i <= n; i++) { //finding solution  for ith floor
            int maxtrymoves = i;
            System.out.println("for floor: " + i);
            for (int j = 1; j <= i; j++) {
                System.out.println("for subfloor " + j);
                int ifbreaks = 1 + j - 1; //max try till j-1 rows
                int ifnotbreaks = 1 + dp[i - j]; //take best of last floor and you try 1 more time
                System.out.println("breaks " + ifbreaks);
                System.out.println("ifnotbreaks " + ifnotbreaks);
                int output = Math.max(ifbreaks, ifnotbreaks);
                maxtrymoves = Math.min(maxtrymoves, output);
                System.out.println("maxtry..... " + maxtrymoves);
            }
            dp[i] = maxtrymoves;
            System.out.println("floor done " + i + "---------------------");

        }
        return dp[n];

    }

    int top_down_drop(int floors, int eggs, int[][] dp) {
        //If the egg breaks, the problem is reduced to x-1 eggs and i - 1 floors
        //If the eggs does not break, the problem is reduced to x eggs and n-i floors
        if (eggs == 1 || floors <= 1)
            return floors;
        if (dp[floors][eggs] > 0)
            return dp[floors][eggs];
        int min = Integer.MAX_VALUE;
        for (int f = 1; f <= floors; f++)
            min = Math.min(min, 1 + Math.max(top_down_drop(f - 1, eggs - 1, dp)
                    , top_down_drop(floors - f, eggs, dp)));
        dp[floors][eggs] = min;
        return min;
    }
}
