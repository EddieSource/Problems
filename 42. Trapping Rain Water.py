'''
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

'''

class Solution:
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        left = 0
        right = len(height) - 1
        ans = 0
        left_max = 0
        right_max = 0
        while (left < right):
            if (height[left] < height[right]):
                if (height[left] >= left_max):
                    left_max = height[left]
                else:
                    ans += left_max - height[left]
                left += 1
            else:
                if (height[right] >= right_max):
                    right_max = height[right]
                else:
                    ans += right_max - height[right]
                right -= 1
        return ans
