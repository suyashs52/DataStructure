package dp.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FROGV {
    //https://www.codechef.com/LP2TO306/problems/FROGV
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {

        int n=fs.nextInt();
        long k=fs.nextInt();
        int  pair=fs.nextInt();


        long[][] xcoord=new long[n][2];
        for (int i = 0; i < n; i++) {
            xcoord[i][0]=fs.nextLong();
            xcoord[i][1]=i+1;
        }

        Arrays.sort(xcoord,(a,b)->{
            if(a[0]>b[0]) return  1;
            else if(a[0]==b[0]) return 0;
            else return  -1;
        });
         int[]bonding=new int[n+1];

         int bond=1;
         bonding[(int)xcoord[0][1]]=bond;
        for (int i = 0; i < n-1; i++) {
            if(xcoord[i+1][0]-xcoord[i][0]<=k){
                bonding[(int)xcoord[i+1][1]]=bond;

            }else {
                bond++;
                bonding[(int)xcoord[i+1][1]]=bond;

            }

        }

        for (int i = 0; i < pair; i++) {
            int p1=fs.nextInt();
            int p2=fs.nextInt();

            if(bonding[p1]==bonding[p2]){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
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
