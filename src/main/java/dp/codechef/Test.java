package dp.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
    //https://www.codechef.com/LP2TO306/problems/SUBINC?tab=statement
    static FastScanner fs = new FastScanner();

    public static void main(String[] args) {

        // your code goes here
        int testCase =fs.nextInt();
        while (testCase-- > 0) {

            int size = fs.nextInt();
            Long[] inp = new Long[size];
            for (int i = 0; i < inp.length; i++) {
                inp[i]=fs.nextLong();
            }

            Arrays.sort(inp);
            long ans =Long.MAX_VALUE;
            long mean=inp[1]+inp[0]+inp[2];
            long median=inp[1]*3;
            ans=Math.abs(median-mean);


            for(int i=1;i<size-1;i++){
                median=inp[i]*3l;
                for(int j=0;j<i;j++){
                    mean=inp[i]+inp[j];
                    long diff=median-mean;
                    if(diff<inp[i]){
                        continue;
                    }else if(inp[i]==diff){
                        ans=Math.min(ans,Math.abs(median-mean-inp[i+1]));
                        continue;
                    }

                    int index=lower(inp,diff)-0;
                    if(index!=size-1 || index<=i){
                        ans=Math.min(ans,
                                Math.abs(mean-median+inp[index]));
                        // index--;
                    }

                    index--;

                    if(index>i){
                        ans=Math.min(ans,Math.abs(mean-median+inp[index]));
                    }


                }
            }

            System.out.println(ans);
        }

        }


    public static int lower(Long[] ages, Long target) {
        if (ages == null || ages.length == 0) {
            return 0;
        }
        int l = 0;
        int r = ages.length - 1;
        if (target <= ages[0]) {
            return 0;
        }
        if (target > ages[r]) {
            return -1;
        }
        while (l  <  r) {
            int m = l + (r - l ) / 2 ;

            if (ages[m] >= target) {
                r = m;
            }else {
                l = m + 1;
            }
        }
        return r;
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





