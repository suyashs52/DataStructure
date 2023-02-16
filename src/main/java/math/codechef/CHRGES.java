package math.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHRGES {

    //https://www.codechef.com/problems/CHRGES?tab=solution

    static FastScanner fs = new FastScanner();

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        int testCase = fs.nextInt();

        while (testCase-- > 0) {
            int size = fs.nextInt();
            String s = fs.next();

            int[] charges = new int[size];
            int charge = 0;
            for (int i = 0; i < size; i++) {
                char ch = s.charAt(i);
                if (ch == '+') {
                    charge = 1;
                } else if (ch == '-') {
                    charge = -1;
                } else {
                    if (charge > 0) {
                        charge++;

                    } else if (charge < 0) {
                        charge--;
                    }
                }

                charges[i]=charge;


            }

            for (int i = size-1; i >-1 ; i--) {
                char ch = s.charAt(i);
                if (ch == '+') {
                    charge = 1;
                } else if (ch == '-') {
                    charge = -1;
                } else {
                    if (charge > 0) {
                        charge++;

                    } else if (charge < 0) {
                        charge--;
                    }
                }

                charges[i]+=charge;


            }
            int ans=0;
            for (int i = 0; i < size; i++) {
                if(charges[i]==0) ans++;
            }

            System.out.println(ans);

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
