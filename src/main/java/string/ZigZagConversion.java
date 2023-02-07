package string;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(convert("AAC",2));
    }

    public static String convert(String s, int numRows) {

        StringBuffer sb=new StringBuffer();

        for(int i=1;i<=numRows;i++){

            int lower=numRows-i;
            lower*=2;
            int upper=i-1;
            upper*=2;
            int j=i-1; //starting char
            sb.append(s.charAt(j));

            for(;j<s.length();){
                j+=lower;
                if(lower!=0 && j<s.length()){
                    sb.append(s.charAt(j));
                }

                j+=upper;
                if(upper!=0 && j<s.length()){
                    sb.append(s.charAt(j));
                }
                //sb.append(s.charAt(i));
            }
        }

        return sb.toString();


    }
}
