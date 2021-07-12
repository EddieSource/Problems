from typing import List


def maxPoints(points: List[List[int]]) -> int:
    if (len(points) == 0): return 0
    if (len(points) == 1): return 1
    globalMax = 0
    mapLineToPoints = {}
    for i in range(0, len(points)):
        p1 = points[i]
        for j in range(i + 1, len(points)):
            p2 = points[j]
            if (p2[0] - p1[0] == 0):
                k = "inf"
                b = p1[0]
            else:
                k = (p2[1] - p1[1]) / (p2[0] - p1[0])
                b = p1[1] - k * p1[0]

            if (k, b) in mapLineToPoints:
                mapLineToPoints[(k, b)].add((p2[0], p2[1]))
            else:
                s = set()
                s.add((p1[0], p1[1]))
                s.add((p2[0], p2[1]))
                mapLineToPoints[(k, b)] = s


            globalMax = max(globalMax, len(mapLineToPoints[(k, b)]))

    return globalMax
