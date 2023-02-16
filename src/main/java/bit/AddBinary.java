package bit;

public class AddBinary {

    //https://leetcode.com/problems/add-binary/description/

    public static void main(String[] args) {
        System.out.println(addBinary("1111", "1111"));
        System.out.println(addBinary("111", "1"));
    }

    public static String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        if (n < m) {
            return addBinary(b, a); //put a greater then b
        }

        int carry=0; //carry always ll be 00 when both 0,01 when any of it  is 1 ,10 both 1
        StringBuilder sb=new StringBuilder();
        int j=m-1;
        for(int i=n-1;i>-1;i--){

            if(a.charAt(i)=='1') carry++;

            if(j>-1 && b.charAt(j--)=='1') carry++;

            if(carry==1 || carry==3) sb.append('1'); //carry is 1, a=1,b=1 so 3
            else sb.append('0');

            if(carry>0)
                //if carry =3 next it should be 1
                carry--; //or carry=carry/2; for 2 carry is 2/2=1 for 1or 0 1/2 0/2 is 0
            if(carry==2)
                carry--;
        }

        if(carry>0)
            sb.append('1');

        sb.reverse();

        return sb.toString();


    }

    public static String addBinary1(String a, String b) {
        //O(n+m) not good for larger number not fit in integer
        Integer ai = Integer.parseInt(a, 2); //convert to decimal
        Integer bi = Integer.parseInt(b, 2);
        System.out.println(ai);
        System.out.println(bi);
        return Integer.toBinaryString(ai + bi);

    }
}
