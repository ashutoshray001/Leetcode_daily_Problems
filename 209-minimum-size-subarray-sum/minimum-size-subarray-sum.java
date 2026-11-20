class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE;
        int sum=0;
        int i=0,
            j=0,
            n=nums.length;
        while(j<n){
            sum+=nums[j];
            while(sum>=target){
                size = Math.min(size,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return size==Integer.MAX_VALUE?0:size;
    }
}