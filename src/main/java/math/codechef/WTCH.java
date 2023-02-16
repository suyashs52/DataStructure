package math.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WTCH {
//https://www.codechef.com/LP2TO308/problems/WTCH?tab=statement
    static FastScanner fs=new FastScanner();

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int testCase=1;//fs.nextInt();

        while (testCase-- > 0){
            int size=11;//fs.nextInt();
            String s="00101010000";//fs.next();
           // int size=11;
            if(size==1){
                if(s.charAt(0)=='0'){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else{
                char prev='0';
                int count=0;
                for(int i=0;i<size;i++){
                    if(prev=='0' && s.charAt(i)=='0'  ){
                        if(i<size-1 && s.charAt(i+1)=='0')
                            count++;
                        else if(i==size-1){
                            count++;
                        }
                        prev='1';
                    }else{
                        prev=s.charAt(i);
                    }
                }



                System.out.println(count);
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
                } catch ( IOException e) {
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
