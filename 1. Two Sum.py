class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # time complexity O(n)

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



