class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList <Integer> arr =new ArrayList<>();
        int a=nums1.length;
        int b=nums2.length;
        int c=Math.max(a,b);
        for(int i=0;i<c;i++){
            if(i<a){
                arr.add(nums1[i]);
                
            }
            if(i<b){
                arr.add(nums2[i]);
                
            }
        }
        arr.sort(null);
        int siz=arr.size();
        double d=(siz%2 ==0) ? (arr.get(siz/2)+arr.get((siz/2)-1))/2.0:arr.get(siz/2);
        return d;
    }
}
