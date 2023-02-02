package binary_search.leetcode;

public class FindInRotatedArray {
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/?envType=study-plan&id=algorithm-ii
    public static void main(String[] args) {
        int[] nums = new int[]{3,1};
        int target = 3;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        //edge case condition
        if(nums[start]==target) return  start;
        if(nums[end]==target) return  end;

        while (start<=end){
            int mid=start+(end-start)/2;

            if(nums[mid]==target){
                return mid;
            }

            //if array rotated by any mean and mid is in non rotated array
            if(nums[start]>nums[mid]){ //must be rotated
                //mid lies in non rotated list
             //   if(target>=nums[start] && target<nums[mi]) cant make this condition as target> nums[start] as well as nums[mid]
                if(target<=nums[end] && target>nums[mid]){ //means target lies in non rotated
                    start=mid+1;
                }else{ //target is less then mid ,continue search in mid-1
                    end=mid-1;
                }

            }else{
              //  nums[mid]>=nums[start] mid can be in  rotated,or start can be in non rotated
                if(target>=nums[start] && target<nums[mid]){ //means mid lies in non rotated
                    end=mid-1; //target is greater and less then mid so narrow search to mid-1
                }else {
                    //target < nums[start] means target lies in non rotated our start is wrong change it
                    start=mid+1;
                }
            }
        }

        return -1;


    }
        public static int search1(int[] nums, int target) {
        //array rotated so find pivot element arr[mid-1]> arr[mid]
        int pivot=findPivot(nums);
        int s=0;
        int e=nums.length-1;
        System.out.println(pivot);

        if(nums[pivot]==target){
            return pivot;
        }
        if(pivot==0){
            s=0;
        }else   if(target>=nums[0]){
            e=pivot-1;
        }else {
            s=pivot;
        }
        System.out.println(e);
        while (s<=e){
            int mid=s+(e-s)/2;

            if(nums[mid]==target){
                return mid;
            } else if (nums[mid]>target) {
                e=mid-1;

            }else {
                s=mid+1;
            }
        }
        return -1;
    }

    static int findPivot(int [] nums){
        int s=0;
        int e=nums.length-1;
        if(nums[s]<=nums[e]){
            return 0;
        }
        while (s<=e){
            int mid=s+(e-s)/2;


            if(nums[mid]>nums[mid+1]){
                return mid+1;
            }
            else if( nums[mid]<nums[s]){
                e=mid-1;

            }else {
                s=mid+1;
            }
        }
        return 0;
    }

}
