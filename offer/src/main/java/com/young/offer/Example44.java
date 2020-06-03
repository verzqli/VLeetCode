package com.young.offer;

class Example44 {
    public static void main(String[] args) {
    }

    public boolean isStraight(int[] nums) {
        if (nums.length<5){
            return false;
        }
        quickSort(nums,0,nums.length-1);
        int jokerCount = 0;
        //��Ϊֻ������������Ϊ���ж��Ƿ������ͬ�������жϵ�4���ɣ��������ж�һ��
        for (int i = 0; i < 4; i++) {
            if (nums[i]==0){
                jokerCount++;
            } else  if (nums[i]==nums[i+1]){
                return false;
            }
        }
        return nums[4]-nums[jokerCount]<5;

    }
    private void quickSort(int[] nums, int l, int r) {
        //��������
        if (l>=r){
            return;
        }
        int start = l+1;
        int right = r;
        while (start<=right){
            if (nums[start]>nums[l]){
                swap(nums,start,right);
                right--;
            }else{
                start++;
            }
        }
        start--;
        swap(nums,start,l);
        quickSort(nums,l,start-1);
        quickSort(nums,start+1,r);
    }
    private void swap(int[] nums, int left, int right) {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
