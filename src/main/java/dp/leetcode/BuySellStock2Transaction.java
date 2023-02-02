package dp.leetcode;

public class BuySellStock2Transaction {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    public static int maxProfit(int[] prices) {

        int n = prices.length + 1;
        int[] profit = new int[n];

        if (prices.length == 1) return 0;
        //check profit at day 1
        for (int i = 2; i < n; i++) {

            if (prices[i] - prices[i - 1] > profit[i]) {

                profit[i] = prices[i] - prices[i - 1];

            }

        }

        for (int day = 2; day < n; day++) {

            for(int s_day=day+1;s_day<n;s_day++){

            }
        }


        return profit[prices.length + 1];

    }
}
