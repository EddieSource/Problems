'''
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

'''

class Solution:
    def bSearch(self, nums, target, mode):
        '''
        :type nums: List[int]
        :type target: int
        :type mode: string
        :rtype: int
        '''
        l = 0
        r = len(nums) - 1
        res = -1
        while(l <= r):
            mid = (l + r)//2
            if(target > nums[mid]):
                l = mid + 1
            elif(target < nums[mid]):
                r = mid - 1
            else:
                res = mid
                if(mode == 'left'):
                    r = mid-1
                elif(mode == 'right'):
                    l = mid+1
        return res

    def searchRange(self, nums, target):
        '''
          :type nums: List[int]
          :type target: int
          :rtype: List[int]
        '''
        return([self.bSearch(nums, target, 'left'),self.bsearch(nums, target, 'right')])