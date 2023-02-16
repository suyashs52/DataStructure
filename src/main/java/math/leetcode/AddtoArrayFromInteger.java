package math.leetcode;

import java.util.LinkedList;
import java.util.List;

public class AddtoArrayFromInteger {

    //https://leetcode.com/problems/add-to-array-form-of-integer/description/

    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9},1));
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {



        List<Integer> list=new LinkedList<>();
        //add last element add reduce k
        for(int i=num.length-1;i>-1;i--){
            int ans=(num[i]+k);
            list.add(0,ans%10);
            k=ans/10;
        }

        while(k>0){
            list.add(0,k%10);
            k=k/10;

        }



        return list;
    }

}
