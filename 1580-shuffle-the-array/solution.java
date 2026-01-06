class Solution {
    public int[] shuffle(int[] nums, int n) {
        int []arr=new int[n*2];
        int k=0;
        int j=0;
        for(int i=1;i<nums.length;i+=2){
            arr[k]=nums[j];
            arr[i]=nums[n+j];
            j++;
            k+=2;
        }

        return arr;
    }
}
