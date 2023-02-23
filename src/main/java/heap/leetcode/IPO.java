package heap.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class IPO {

    //https://leetcode.com/problems/ipo/description/

    public static void main(String[] args) {
        IPO ip=new IPO();
        //System.out.println(ip.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
        System.out.println(ip.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
    }

    public   int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        capital[] caps=new capital[profits.length];
        for(int i=0;i<capital.length;i++){
            caps[i]=new capital(profits[i],capital[i]);
        }
        Arrays.sort(caps); //sort based on asc capital

        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());//sort based on desc profit to get max profit
        int j=0;
        int maxcap=w;
        while(k>0){
            while(j<capital.length && caps[j].capital<=w ){
                heap.add(caps[j].profit);
                j++;
            }
            if(heap.isEmpty()) break;
            maxcap+=heap.poll();
            w=maxcap;
            k--;
        }

        return maxcap;

    }

    class capital implements Comparable<capital>{
        Integer profit;
        Integer capital;
        capital(Integer profits,Integer capital){
            this.profit=profits;
            this.capital=capital;
        }

        @Override
        public int compareTo(capital cap) {
          return   capital.compareTo(cap.capital);

        }
    }
}
