def valor_abs(n: int) -> int:
    if n < 0:
        n = -n
    return n


def triangular(n: int, m: int) -> int:
    valor = (valor_abs(n))/(valor_abs(n-m)*valor_abs(m))
    return valor


print(triangular(-3, 2))
