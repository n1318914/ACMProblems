/*
 * 文件名：Q0001.java
 * 版权：Copyright by www.ixuenong.com
 * 描述：
 */

package com.main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q0001
{
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(nums[i] > target){
                continue;
            }    
            int des = target - nums[i];
            if(map.containsKey(des))
            {
                return new int[]{map.get(des),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    public static void main(String[] args)
    {
        int[] twoSum = twoSum(new int[] {2, 7, 11, 15}, 9);
        String string = Arrays.toString(twoSum);
        System.out.println(string);
    }
}
