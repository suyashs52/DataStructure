package dp.leetcode;

import java.util.HashMap;
import java.util.Map;

public class EggDropkEggNFloor {

    static Map<Integer, Integer> map = new HashMap<>();


    //binomial math

    //   https://leetcode.com/problems/super-egg-drop/solutions/2935996/extremely-efficient-binomial-approach-to-the-eggdrop-problem/?envType=study-plan&id=dynamic-programming-iii

    public static void main(String[] args) {
        //https://leetcode.com/problems/super-egg-drop/?envType=study-plan&id=dynamic-programming-iii
        System.out.println(superEggDrop(2, 6)); //egg, floor
        System.out.println(dp_topdown(2, 6)); //egg, floor
        System.out.println(dp_bottomup(2, 6)); //egg, floor
    }

    //floor varies to N move moves from 0 to required
    public static int superEggDrop(int k, int n) {
        //need to find minium move of random outcome from a floor,so take worst from floor outcome and take min of all floor worst result
        //ll be the best answer
        //so for k egg , n floor we have f(k,n)=1+ min(max(f(k-1,x-1),f(k,n-x)) if egg break at xth floor check remianing x-1 floor starting from 1
        // if not break check above same for n-x floors,k eggs starting from x+1(just above floor)
        //we can also understand we need minium move for given k egg and n floor so min move need for x floor
        //dp[m][k] contain maximum floor we can cover from m move and k eggs
        //dp[m][k]=1+dp[m-1][k-1]+dp[m-1][k] it is sum of 1 as one move done, floor covered when egg break and floor covered when egg not break
        //if dp[m][k]=N then m ll be minimum move needed for N floor and k eggs
        //here we can see we are chekcing only prev row record, and have k colms only

        int[] dp = new int[k + 1]; //need to check floor of prev moves only f
        //for 0 move

        int m = 0;
        while (dp[k] < n) { //unitill we have n floor for m move k eggs m is min moves needed
            m++;
            for (int eggs = k; eggs > 0; eggs--) {
                dp[eggs] = 1 + dp[eggs - 1] + dp[eggs]; //floor for m move
            }
        }

        return m;


    }

    //for a k run the binary search
    static int dp_topdown(int k, int n) {
        //KNLog(N), KN
        //we already know  f(k,n)=1+ min(max(f(k-1,x-1),f(k,n-x))
        //here 2 function f(k-1,x-1) increase as x increase
        // f(k,n-x) ll decrease as x increase for fixed k
        //we need to find minimum so intersection point would be minimum so caluclate max of both function
        //and see if reaching min value for a given x if both equal then have answer if f(k-1,x-1) has max value go prev
        //as it is always increasing with x , iff(k-1,n-x) has max value go ahead to find value as it is decreating function

        if (map.containsKey(n * 100 + k)) { //k is upto 100 only so this is unique
            return map.get(n * 100 + k);
        }

        int left = 1; //min move is 1 at least
        int right = n; //max move is n
        if (k == 1) {//minium k is 1
            map.put(n * 100 + k, n);
            return n;
        }

        if (n == 0) {
            map.put(n * 100 + k, 0);
            return 0;
        }
        int ans = n;
        while (left + 1 < right) {

            int mid = left + (right - left) / 2;

            int l = dp_topdown(k, n - mid); ///decreasing func
            int r = dp_topdown(k - 1, mid - 1);//increasing func

            if (l > r) { //we are at left side as in this case r func return lesser amount move right to get common move
                left = mid;
            } else if (r > l) {
                right = mid;
            } else {
                left = right = mid;
            }

            //for this move x store the value in map


        }

        ans = 1 + Math.min(Math.max(dp_topdown(k - 1, left - 1), dp_topdown(k, n - left)),
                Math.max(dp_topdown(k - 1, right - 1), dp_topdown(k, n - right)));

        map.put(n * 100 + k, ans);
        return map.get(n * 100 + k);


    }


    private static int dp_bottomup(int K, int N) {
        //   f(K,N)=1+ miN(max(f(K-1,x-1),f(K,N-x))

        int[] dp = new int[N + 1]; //no of floor
        //for K=1 we need x move for x floor

        for (int i = 0; i <= N; ++i) {
            dp[i] = i; //egg 1
        }

        for (int k = 2; k <= K; ++k) {
            int[] dp2 = new int[N + 1];
            int x = 1;
            for (int n = 1; n <= N; ++n) {

                //find the min move for given egg and n floor
                //x value from 1 to x(min value) f(K,n-x) first decrease for higher value of x
                //if any time we got reverse value ie current value is < next value that would be our minimum
                //and that is our move dp is when egg breaK, dp2 if egg not breaK
                while (x < n && (Math.max(dp[x - 1], dp2[n - x]) > Math.max(dp[x + 1 - 1], dp2[n - (x + 1)]))) {
                    x++;
                }

                dp2[n] = 1 + Math.max(dp[x - 1], dp2[n - x]); //current move is 1+ min(max(egg breaK floor -1),max(egg not breaK n-floor))


            }
            dp = dp2;
        }
        return dp[N];
    }

}
