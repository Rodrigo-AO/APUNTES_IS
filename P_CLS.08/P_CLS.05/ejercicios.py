"""
17. Dado un número n defina una función que lea desde teclado n
números enteros y devuelva cuántos de ellos son pares.
"""


def es_par(x) -> bool:
    par = False
    if x % 2 == 0:
        par = True
    return par


def numeros(n: int) -> int:
    contador = 0
    for i in range(n):
        x = int(input("Deme su número entero: "))
        if es_par(x) == True:
            contador = contador + 1
    return contador


"""
18. Dados dos números n y m defina una función que lea desde teclado
n números enteros y devuelva la suma de los múltiplos de m.
"""


def es_multiplo(n: int, m: int) -> bool:
    if n % m == 0:
        valor = True
    else:
        valor = False
    return valor


def suma_multiplos(n, m):
    suma = 0
    for i in range(n):
        if es_multiplo(n, m):
            suma = suma + n
    return suma


"""
19. Dados dos números enteros n y m devuelva la suma de los números entre n y m ambos inclusive.
Tenga presente que n puede ser menor que m, igual o mayor. Por ejemplo si la función se invoca
suma_entre(5,7) devuelve 18 y si se invoca suma_entre(8,5) devuelve 26.
"""


def suma_numeros(n: int, m: int) -> int:
    suma = 0
    if n >= m:
        for i in range(m, n+1):
            # i irá aumentando hasta llegar al valor n
            # Ponemos m+1 para que si el rango es 0 al menos sume los numeros n y m
            suma = suma + i
    else:
        for i in range(n, m+1):
            suma = suma + i
    return suma


print(suma_numeros(90, 12))
print(suma_numeros(12, 90))

"""
20. Dados dos números n y m defina una función que lea desde teclado n números enteros y devuelva el mínimo. Ídem para el máximo.
"""


def numero_minimo(n, m):
    minimo = str("")
    if n >= m:
        minimo = f"{m} es el mínimo"
    else:
        minimo = f"{n} es el mínimo"
    return minimo


print(numero_minimo(6534648616521316546128649613489461313189,
      123216374687961378461237513164946464))
