# Dado un nº n entero positivo devuelve la suma desde 1 hasta n
def suma_n_primeros(n: int) -> int:
    suma = 0
    for i in range(1, n+1):
        # i es una variable de tipo contador que cada vez que se ejecuta su linea aumenta su valor en 1, 2, 3...
        suma = suma+i
        # tambien suma+=i (que sume i y suma se redefina como el resultados)
    return suma


print(suma_n_primeros(4))
