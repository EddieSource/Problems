'''
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
'''

def sortColors(nums):
    '''

    :param nums: list
    :return: None
    '''
    #1st solution: count occurrences and reconstruct array
    #2nd solutin)implemented below: key is to shortent the range
    # after the swap(no need to traverse the swapped element)
    # i as well
    left = 0
    right = len(nums) - 1

    i = 0

    while(i <= right):
        if (nums[i] == 0):
            temp = nums[i]
            nums[i] = nums[left]
            nums[left] = temp
            i+=1
        elif (nums[i] == 1):
            i+=1
        elif (nums[i] == 2):
            temp = nums[i]
            nums[i] = nums[right]
            nums[right] = temp
            right -= 1



nums = [2,0,1]
sortColors(nums)
print(nums)
