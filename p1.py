'''
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
'''

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # a time complexity O(n)
        
        h = {}  #create a hash map
        for pos, num in enumerate(nums):
            n = target - num
            if n not in h:
                h[num] = pos
            else:
                return [h[n], pos]

        for i in range(len(nums)):
            if(nums[i] in h):
                return([i, h[nums[i]]])
            h[target - nums[i]] = i



