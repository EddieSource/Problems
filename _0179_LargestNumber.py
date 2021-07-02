class LargerNumKey(str):
    def __lt__(cur, another):
        return cur + another > another + cur


class Solution:
    def largestNumber(self, nums):
        largest_num = ''.join(sorted(map(str, nums), key=LargerNumKey))
        return '0' if largest_num[0] == '0' else largest_num

