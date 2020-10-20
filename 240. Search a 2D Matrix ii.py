"""
Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

"""


def searchMatrix(matrix, target):
    """
    :type matrix: List[List[int]]
    :type target: int
    :rtype: bool
    """

    m = len(matrix)
    if (m == 0):
        return False
    n = len(matrix[0])
    if (n == 0):
        return False
    x = 0
    y = n - 1
    while (x < m and y >= 0):
        if (target == matrix[x][y]):
            return True
        elif (target > matrix[x][y]):
            x += 1
        else:
            y -= 1

    return False


