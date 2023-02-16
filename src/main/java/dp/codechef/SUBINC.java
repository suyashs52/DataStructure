package dp.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SUBINC {
//https://www.codechef.com/LP2TO306/problems/SUBINC?tab=statement
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
            int testCase=fs.nextInt();

            while (testCase-- > 0){
                int size=fs.nextInt();
                long [] arr=new long[size];

                for (int i = 0; i < size; i++) {
                    arr[i]=fs.nextLong();
                }
        /*
2
4
1 4 2 3
1
5
         */
              //  nonDesceasingArray_rec(arr);

               // dp(arr);
                System.out.println(array_o_n(arr));
            }
    }

    private static int dp(int[] arr) {

        //size starting from index

        int max=arr.length;

        for(int i=0;i<arr.length;i++){
            int size=1;
            for(int j=i+1;j<arr.length;j++){
                    if(arr[j]>arr[j-1]){
                        size++;
                    }
            }
        }

        return  max;

    }

    private static long array_o_n(long[] arr){
        long ans=1;
        long[] dp=new long[arr.length];
        dp[0]=1;
        for(int i=1;i<arr.length;i++){
            dp[i]=1;
            if(arr[i]>=arr[i-1]){
                dp[i]+=dp[i-1];
               // ans++;
            }
            ans+=dp[i];
        }


        return ans;
    }

    private static void nonDesceasingArray_rec(int[] arr) {
        int n=arr.length;
        int count=0;
        for (int i = 0; i < n; i++) {
            count++;
            //array size from 1 to n, as index increase size ll be less
            for (int j = 2; j <=n-i ; j++) {
                boolean found=true;
                for (int k = i; k < i+j-1; k++) {
                    if(arr[k]>arr[k+1]){
                        found=false;
                        break;
                    }
                }
                if (found) count++;
            }

        }

        System.out.println(count);
    }


    static class FastScanner {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine().strip());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
