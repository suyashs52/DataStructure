package dp.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
    //https://www.codechef.com/LP2TO306/problems/SUBINC?tab=statement
    static FastScanner fs = new FastScanner();

    public static void main(String[] args) {

        // your code goes here
        int testCase = fs.nextInt();

        while (testCase-- > 0) {

            int n = fs.nextInt();
            String s=fs.next();

            int index1=s.indexOf('+');
            int index2=s.indexOf('-');

            if(index2==-1 && index1==-1){
                System.out.println(n);
            }
            else{
                char plus='+';
                int minus='-';

                String ss=s;
                int ans=0;
                while(ss.isEmpty()==false){
                    int left=ss.indexOf('+');
                    int right=ss.indexOf('-');
                    int min=Math.min(left,right);
                    int max=Math.max(left,right);

                    if(max-min>1){
                        ans++;
                        ss=ss.substring(max);
                    }

                    if(max==-1){
                        break;
                    }


                }
                  index1=ss.indexOf('+');
                  index2=ss.indexOf('-');

                if(index2==-1 && index1==-1){
                   ans+=ss.length();
                }
                System.out.println(ans);

            }


        }
    }

    private static boolean palin(int[] in) {
        boolean ispalin = true;
        for (int i = 0; i < in.length; i++) {
            if (in[i] != in[in.length - 1 - i]) {
                return false;
            }
        }
        return true;

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
        while (l < r) {
            int m = l + (r - l) / 2;

            if (ages[m] >= target) {
                r = m;
            } else {
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





