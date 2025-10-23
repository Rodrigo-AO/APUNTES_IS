# Definir una funcion que devuelva si un numero es primo o no
'''
esquema existe(coleccion de elementos, condicion)
    existe=falso
    hacemos un recorrido de la coleccion
        si el elemento cumple la condicion
        existe=verdad
        break
'''


def es_multiplo(n:int)->bool:
    existe=False
    for i in range(2,n): #Comprobamos que sea multiplo de dos y sigue aumentado valores (i)
        if es_multiplo(n,i):
            existe=True
            break
        return existe

def es_primo(n:int)->bool:
    return not es_multiplo(n)

'''
esquema paraTodo(coleccion, condicion)
    paraTodo=verdad
    recorremos la coleccion:
        si el elemento NO cumple la condicion
            paraTodo=falso
            break
    devuelve paraTodo         
'''

def es_primo(n:int)->bool:
    paraTodo=True
    for i in range(n, i):
        if es_multiplo(n,i):
            paraTodo=False
            break
    return paraTodo
