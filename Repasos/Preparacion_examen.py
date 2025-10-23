'''
Tenemos tres variables a1, a2 y a3 de tipo Automovil. Escriba una expresión lógica que devuelva True para
cada una de estas condiciones:

1. Inicialice una variable de tipo Automóvil con los datos que quiera.
2. El automóvil a1 se diseñó antes de 2023
3. El automóvil a2 es eléctrico y está disponible en color Negro
4. La última matriculación del automóvil a3 es 5434MLP
5. Ni a1 ni a2 son eléctricos pero a3 sí
6. Del automóvil a2 se han vendido al menos 5 coches
7. El automóvil a1 se vende en España pero no en Italia
8. El automóvil a1 se vende en más países que el a2 pero en menos que el a3
9. El automóvil a1 se vende en más países que el a2 o tiene más colores que el a3
10. El automóvil a1 se vende en Francia o España pero no en ambos
11. La primera matriculación del automóvil a2 empieza por el mismo dígito que la primera matriculación
del automóvil a3.
'''

import datetime
from typing import NamedTuple

Automovil = NamedTuple('Automovil', [('marca', str), ('fecha', datetime), ('electrico', bool),
                                     ('colores', set[str]), ('paises', set[str]), ('matriculaciones', list[str])])

a1 = Automovil('Ford', '13/09/2014', False, ('Rojo', 'Negro', 'Blanco'),
               ('Alemania', 'Francia', 'Inglaterra'), ['8269HKR', '7143MNZ', '6816QKX'])

a2 = Automovil('Ferrari', '28/10/2019', True, ('Rojo', 'Negro', 'Blanco', 'Amarillo'),
               ('Alemania', 'España'), ['2628PXY', '3714SDF', '9472LMJ'])

a3 = Automovil('McLaren', '03/12/2021', True, ('Negro', 'Blanco'),
               ('Alemania', 'Francia', 'España', 'Inglaterra'), ['2057PXY', '1926QJT', '9281LRX', '5434MLP'])

lista = [a1, a2, a3]

def matriculados_por_marca(lista: list[Automovil], marca: str) -> int:
    lista_matriculados = []
    for e in lista:
        if e.marca == marca:
            lista_matriculados.append(len(e.matriculaciones))
    return sum(lista_matriculados)

def matriculaciones_totales(lista: list[Automovil]) -> int:
    matriculaciones = 0
    for e in lista:
        matriculaciones = matriculaciones + len(e.matriculaciones)
    return matriculaciones

def colores_disponibles(lista: list[Automovil], marca: str) -> set:
    colores = set()
    for e in lista:
        if e.marca == marca:
            colores.add(e.colores)
    return colores

def fechas_electricos(lista: list[Automovil]) -> list:
    fechas = []
    for e in lista:
        if e.electrico == True:
            fechas.append(e.fecha)
    fechas.sort(reverse=True)
    return fechas

def funcion_2(lista1,lista2):
    suma=0
    for i,x in enumerate(lista1):
        if x>=lista2[i]:
            suma+=x
        else:
            suma-=x
    return suma 

print(funcion_2([1,2,3],[4,5,2]))