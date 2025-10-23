import math


def area_longitud(r: int) -> int:
    area = math.pi*r**2
    longitud = 2*math.pi*r
    return area, longitud


print(area_longitud(8))
