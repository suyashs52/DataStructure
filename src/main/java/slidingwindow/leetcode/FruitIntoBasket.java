package slidingwindow.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
//https://leetcode.com/problems/fruit-into-baskets/
    public static void main(String[] args) {
      //  System.out.println(totalFruit(new int[]{1,2,1}));
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(totalFruit(new int[]{1,1,2,2}));
        System.out.println(totalFruit(new int[]{0,1,6,6,4,4,6}));


    }
    public static int totalFruit(int[] fruits) {
        int max=0;
        if(fruits.length<3) return fruits.length;

        Map<Integer,Integer> map=new HashMap<>();
        int left=0;
        for (int i = 0; i < fruits.length; i++) {


                map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);

                while (map.size()>2){
                    map.put(fruits[left],map.get(fruits[left])-1);

                    if(map.get(fruits[left])<=0){
                        map.remove(fruits[left]);
                    }
                    left++;

                }
                max=Math.max(max,i-left+1);

        }

        return max;
    }
        public static int totalFruit1(int[] fruits) {

        if(fruits.length<3) return fruits.length;

        int a=fruits[0];
        int b=-1;
        int max=2;

        int a1=1;
        int b1=0;
        if(fruits[1]==fruits[0]){
            a1++;
        }else {
            b1++;
            b=fruits[1];
        }
        for(int i=2;i<fruits.length;i++){
            if(fruits[i]==a){
                a1++;
            } else if (fruits[i]==b) {
               b1++;

            }else {
                if(b==-1){
                    b1++;
                    b=fruits[i];
                }
                else if(fruits[i-1]==a){
                    b1=1;
                    b=fruits[i];
                    if(fruits[i-2]==a) a--;
                }else {
                    a1=1;
                    a=fruits[i];
                    if(fruits[i-2]==b) b--;
                }
            }

            max=Math.max(a1+b1,max);
        }

        return  max;

    }
}
