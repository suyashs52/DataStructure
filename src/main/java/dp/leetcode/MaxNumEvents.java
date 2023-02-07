package dp.leetcode;

import java.util.Arrays;

public class MaxNumEvents {

    //https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
    public static void main(String[] args) {
//        System.out.println(maxEvents(new int[][]{
//                {1, 2}, {2, 3}, {3, 4}
//        }));

        System.out.println(maxEvents(new int[][]{
                {1, 4}, {4, 4}, {2, 2},{3,4},{1,1}
        }));
    }

    public static int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            if(a[1]==b[1]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        for (int i = 0; i < events.length; i++) {
            for (int j = 0; j < events[0].length; j++) {
                System.out.print(events[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(events);
        int max=0;
        int minjob=-1;
        for(int[] eve:events){
            if(eve[0]>=minjob){
                max++;
                minjob=eve[1];
            }
        }

        return max;
    }
}
