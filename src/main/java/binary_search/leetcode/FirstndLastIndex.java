package binary_search.leetcode;

public class FirstndLastIndex {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
    //check bound
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ans=searchRange(nums,target);
        System.out.println(ans[0]+","+ans[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        ans[0]=bs(nums,target,true);
        ans[1]=bs(nums,target,false);
        return ans;
    }

    public static int bs(int[] nums,int target,boolean isFirst){

        int start=0;
        int end=nums.length-1;

        while (start<=end){
            int mid=start+(end-start)/2;

            if(nums[mid]==target){
                if(isFirst){
                    if(mid==0) return 0;
                     if(nums[mid-1]==nums[mid]){
                         end=mid-1; //traverse left more;
                     }else return mid;
                }else {
                    if(mid==nums.length-1){
                        return mid;
                    }
                    if(nums[mid+1]==nums[mid]){
                        start=mid+1; //last found right side still need to traverse
                    }else {
                        return mid;
                    }
                }

            }else if(nums[mid]>target){ //if mid element is greater then target serch in left
                end=mid-1;
            }else {
                start=mid+1;
            }
        }

        return -1;
    }


    public int[] searchRange1(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};

        int start = 0;
        int end = nums.length;
        int mid = start;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (nums[mid] == target && nums[mid - 1] != nums[mid]) {
                ans[0] = mid;
            }
            if (nums[mid] == target && nums[mid + 1] != nums[mid]) {
                ans[1] = mid;
            } else if (nums[mid] > target) { //if a mid is greater than target then element found left side
                end = mid - 1;
            } else {
                start = mid;
            }
        }

        if (ans[0] != 0) {
            while (start <= mid && nums[mid - 1] > 0) {

            }
        }

        return ans;
    }
}
