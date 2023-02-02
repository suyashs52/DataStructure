package dp.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SUBINC {
//https://www.codechef.com/LP2TO306/problems/SUBINC?tab=statement
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
            int testCase=fs.nextInt();

            while (testCase-- > 0){
                int size=fs.nextInt();
                int [] arr=new int[size];

                for (int i = 0; i < size; i++) {
                    arr[i]=fs.nextInt();
                }
        /*
2
4
1 4 2 3
1
5
         */
                nonDesceasingArray_rec(arr);
            }
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
