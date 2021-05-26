'''
Given an array of integers that is already sorted in ascending order,
find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers
such that they add up to the target, where index1 must be less than index2.

'''

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        """
        :type numbers: List[int]
        :type target: int
        :rtype: int
        """

        left = 0
        right = len(numbers) - 1

        while (left < right):
            if (numbers[left] + numbers[right] < target):
                left += 1
            elif (numbers[left] + numbers[right] > target):
                right -= 1
            else:
                return [left + 1, right + 1]