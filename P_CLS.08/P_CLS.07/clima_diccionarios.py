'''
DIFERENTES ESTRUCTURAS DE DATOS
tuplas (tuple) --> (    ,   ,   ,   ,   )
    - Son invariables
    - La información se estructura en campos

listas (list) --> [     ,   ,   ,   ,   ]
    - Son ordenables
    - A sus campos se puede acceder mediante un índice (ej: i)

conjuntos (set) --> {   ,   ,   ,   ,   }
    - Sus campos no son accesibles mediante un índice
    - No se pueden repetir elementos en su interior

diccionarios (dict)
    - La información NI ESTA ORDENADA NI ES ORDENABLE
    - Mediante una llave se acceden a varios elementos: ('Llave': 'elemento_1', 'elemento_2'...)
    - Posteriormente se puede transformar a una lista del tipo [('Llave', 'elemento_1', 'elemento_2'...), ('Llave_2', ...)],
      la cual si se puede ordenar
'''
from datetime import datetime
from typing import NamedTuple
import csv
from clima_funciones import *
from collections import Counter, defaultdict

'''
1. Devuelve un diccionario que a cada año le hago corresponder un contador con el número de
registros de ese año.
'''

def diccionario_contador_por_año(lista: list[RegistroClima]) -> dict[int, int]:
    dict = {}
    for e in lista:
        clave = e.fecha.year #A cada año le corresponde el numero de registros
        if clave in dict:
            dict[clave] += 1
        else:
            dict[clave] = 1
    return dict

'''
2. Devuelve un diccionario tal que dado un año devuelve el número de registros por mes de
ese año.
'''

def diccionario_contador_por_mes_1(lista: list[RegistroClima], año: int) -> dict[int, int]:
    dict = {}
    for e in lista:
        if e.fecha.year == año:
            clave = e.fecha.month
            if clave in dict:
                dict[clave] += 1
            else:
                dict[clave] = 1
    return dict

def diccionario_contador_por_mes_2(lista: list[RegistroClima], año: int) -> dict[int, int]:
    dict = {}
    lista_filtrada = [e for e in lista if e.fecha.year == año]
    for e in lista_filtrada:
        clave = e.fecha.month
        if clave in dict:
            dict[clave] += 1
        else:
            dict[clave] = 1
    return dict

'''
3. Repita el ejercicio 2 usando el tipo Counter
'''

def diccionario_contador_por_mes(lista: list[RegistroClima], año: int) -> dict[int, int]:
    return Counter(e.fecha.month for e in lista if e.fecha.year == año)

'''
4. Devuelva un diccionario tal que dado un año devuelva para cada mes la lluvia acumulada
en ese mes.
'''

def diccionario_lluvia_acumulada_por_mes(lista: list[RegistroClima], año: int) -> dict[int, float]:
    dict = {}
    for e in lista:
        if e.fecha.year == año:
            clave = e.fecha.month
            if clave in dict:
                dict[clave] += e.lluvia
            else:
                dict[clave] = e.lluvia
    return dict

# Tambien se puede hacer creando la lista filtrada

'''
5. Repita el ejercicio 4 usando el tipo defaultdict
'''

def defaul_diccionario_lluvia_acumulada_por_mes(lista: list[RegistroClima], año: int) -> dict[int, float]:
    dict = defaultdict(float)
    lista_filtrada = [e for e in lista if e.fecha.year == año]
    for e in lista_filtrada:
        clave = e.fecha.month #defauldictno da error si se trata de invocar una clave inexistente, sino que le asigna 0
        dict[clave] += e.lluvia
    return dict

'''
6. Dado un año devuelva un diccionario tal que asocie a cada mes de ese año la temperatura
máxima media de ese mes
'''

#Las claves serán los meses de ese año y tendremos 2 diccionarios, uno contador y otro que suma las temperaturas
def diccionario_tempmax_media_por_mes(lista: list[RegistroClima], año: int) -> dict[int, float]:
    lista_filtrada = [e for e in lista if e.fecha.year == año]
    dicc_contador = Counter(e.fecha.month for e in lista_filtrada)
    dicc_suma = {}
    dicc_media = {}
    for e in lista_filtrada:
        clave = e.fecha.month
        if clave in dicc_suma:
            dicc_suma[clave] += e.temp_max
        else:
            dicc_suma[clave] = e.temp_max
    for mes in dicc_suma:
        dicc_media[clave] = dicc_suma[mes]/dicc_contador[clave]
    return dicc_media
    # return {mes:dicc_suma[mes]/dicc_contador[mes] for mes in dicc_contador}

'''
7. Usando el ejercicio 6 y dado un año devuelva cuál es el mes de ese año con la
temperatura máxima media mayor.
'''

def mes_mayor_tempmax_media(lista:list[RegistroClima], año:int)->int:
    dicc_temp_media=diccionario_tempmax_media_por_mes(lista, año)
    return max(dicc_temp_media.items(), key=lambda x:x[1])[0]

'''
8. Dado un año devuelva un diccionario que haga corresponder a cada mes de ese año una
lista con los RegistrosClima de ese mes.
'''

def diccionario_registros_por_mes(lista: list[RegistroClima], año: int) -> dict[int, list[RegistroClima]]:
    lista_filtrada = [e for e in lista if e.fecha.year == año]
    dicc = {}
    for e in lista_filtrada:
        clave = e.fecha.month
        if clave in dicc:
            dicc[clave].append(e)
        else:
            dicc[clave] = list[e]
    return dicc

'''
9. Dado un año, devuelva un diccionario en el que a cada mes de ese año le haga
corresponder el día con más lluvia.
'''

def diccionario_maximo_lluvia_por_mes(lista: list[RegistroClima], año: int) -> dict[int, datetime]:
    dicc_organizador = diccionario_registros_por_mes(lista, año)
    dicc = {}
    for mes in dicc_organizador:
        dicc[mes] = max(dicc_organizador[mes], key = lambda x: x.lluvia)
    return dicc

'''
10. Devuelve un diccionario en el que las claves sean los años y los valores el día más frio
de cada año.
'''

def diccionario_dia_mas_frio_por_año(lista: list[RegistroClima]) -> dict[int, datetime]:
    dicc_organizador = {}
    for e in lista:
        clave = e.fecha.year
        if clave in dicc_organizador:
            dicc_organizador[clave].append(e)
        else:
            dicc_organizador[clave] = [e]
    dicc = {}
    for año in dicc_organizador:
        dicc[año] = min(dicc_organizador[año], key = lambda x: x.temp_min)
    return dicc


def diccionario_dia_mas_frio_por_año(lista: list[RegistroClima]) -> dict[int, datetime]:
    dicc_organizador = {}
    for e in lista:
        clave = e.fecha.year
        if clave in dicc_organizador:
            dicc_organizador[clave].append(e)
        else:
            dicc_organizador[clave] = [e]
    dicc = {}
    for año in dicc_organizador:
        reg_min = min(dicc_organizador[año], key = lambda x: x.temp_min)
        
    return dicc