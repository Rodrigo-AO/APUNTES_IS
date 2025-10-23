# Funcion que vea si el 1º nº es multiplo del 2º

def multiplos(a: int, b: int) -> bool:
    if a % b == 0:
        es_multiplo = True
    else:
        es_multiplo = False
    return es_multiplo


print(multiplos(2, 4))
print(multiplos(4, 2))

# Funcion que recicle la anterior y vea si el 1º es par


def es_par(n: int) -> bool:
    return multiplos(n, 2)


print(es_par(10))
