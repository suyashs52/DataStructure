package math;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(4,10));
    }
    static int gcd(int a, int b){

        if(b==0) return  a;

        return gcd(b,a%b); //b comes first as it is remainder when a)b(c so if b is 0 a is answer

    }
}
