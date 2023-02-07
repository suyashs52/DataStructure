package slidingwindow.leetcode;

public class FindPermutatedString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("abcdxabcde","abcdeabcdx"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        int len=s1.length();
        int start=0;
        int [] check=new int[26];
        int [] check2=new int[26];
        boolean [] visited=new boolean[26];
        if(s2.length()<s1.length()) return false;

        for(int i=0;i<s1.length();i++){
            check[s1.charAt(i)-'a']++;
        }



        for(int i=0;i<s1.length();i++){
            int index=s2.charAt(i)-'a';
            check2[index]++;

            if(check[index]>0 && check2[index]==check[index] ){
                start+=check[index];
            }
            if(start==len) return true;
        }

        int remain=s2.length()-s1.length();
        for(int i=s1.length();i<s2.length();i++){
            int oldIndex=s2.charAt(i-s1.length())-'a';

            if(check[oldIndex]>0 && check2[oldIndex]==check[oldIndex] ){
                start-=check[oldIndex];
            }
            check2[oldIndex]--;
            int index=s2.charAt(i)-'a';
            check2[index]++;

            if(check[index]>0 && check2[index]==check[index] ){
                start+=check[index];

            }
            if(start==len) return true;
        }
        return false;

    }

}
