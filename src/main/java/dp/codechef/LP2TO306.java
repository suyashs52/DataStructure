package dp.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LP2TO306 {

    static FastScanner fs=new FastScanner();


    public static void main(String[] args) {

        System.out.println( Integer.parseInt('1'+""));

        int limit = 100000;

        int factors[] = new int[limit+1];
        for(int i=2;i<=limit;i++){
            if(factors[i]==0){
                factors[i]=1;
                for(int j=i+i;j<=limit;j+=i){
                    factors[j] += 1;
                }
            }
        }

        int arr[ ][] = new int[6][limit+1];
        for(int i=2;i<=limit;i++){
            if(factors[i]<=5){
                arr[factors[i]][i] = 1;
            }
        }

       int[][] ans = new int[6][limit+1];

        for(int k=1;k<6;k++){
            for(int i=2;i<=limit;i++){
                ans[k][i] = arr[k][i]+ans[k][i-1];
            }


        }


        //check at a number how many prime


        int testcase=fs.nextInt();

        while(testcase>0){

            int f=fs.nextInt();
            int s=fs.nextInt();
            int k=fs.nextInt();
            //inclusive so total prime till s - f one less as f inclusive
            System.out.println(ans[k][s]-ans[k][f-1]);


            testcase--;
        }
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
