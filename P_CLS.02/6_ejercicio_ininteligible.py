import math

# Valor abs de un nº entre el valor abs de el producto de (nº-m) * m
def triangular(n:float, m=float)->float:
    return abs(n) / (abs(n-m) * abs(m))

print(triangular(-7, 8))
