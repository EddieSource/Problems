"""
Given an array nums of n integers where n > 1,
return an array output such that output[i] is equal to the product of
all the elements of nums except nums[i].

"""

def productExceptSelf(nums):
    '''

    :param nums: list
    :return: list
    '''

    res_l = [0] * len(nums)
    res_l[0] = 1
    for i in range(1, len(res_l)):
        res_l[i] = nums[i - 1] * res_l[i-1]

    R = 1
    for i in reversed(range(len(res_l))):
        res_l[i] = res_l[i] * R
        R *= nums[i]

    return res_l


print(productExceptSelf([1,2,3,4]))