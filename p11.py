'''
Given n non-negative integers a1, a2, ..., an ,
where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that
the two endpoints of line i is at (i, ai) and (i, 0).

Find two lines, which together with x-axis forms a container,
such that the container contains the most water.
'''


class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        # time complexity O(n)
        # start with the beginning pos and the end pos and decrease the rod 1 by 1

        m = 0
        pos1 = 0
        pos2 = len(height) - 1
        while pos1 < pos2:
            area = (pos2 - pos1) * min(height[pos1], height[pos2])
            m = max(area, m)
            if (height[pos1] <= height[pos2]):
                pos1 += 1
            else:
                pos2 -= 1
        return m

