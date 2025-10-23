import csv
from typing import NamedTuple
import matplotlib as plt

FrecuenciaNombre = NamedTuple('FrecuenciaNombre', [('año', int), ('nombre', str), ('frecuencia', int), ('genero', str)])

def lee_frecuencias_nombres(fichero) -> list[FrecuenciaNombre]:
    res:list = []
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f)
        next(lector)
        for año, nombre, frecuencia, genero in lector:
            año:int = int(año)
            nombre:str = str(nombre)
            frecuencia:int = int(frecuencia)
            genero:str = str(genero)
            nombres = FrecuenciaNombre(año, nombre, frecuencia, genero)
            res.append(nombres)
    return res

def filtrar_por_genero(lista:list[FrecuenciaNombre], genero:str) -> list[FrecuenciaNombre]:
    res:list = []
    for entrada in lista:
        if(entrada.genero == genero):
            res.append(entrada)
    return res

def calcular_nombres(lista:list[FrecuenciaNombre], genero:str = None) -> set[str]:
    res:set = set()
    for e in lista:
        if(e.genero == genero or genero == None):
            res.add(e.nombre)
        else:
            continue
    return res

def calcular_top_nombres_de_año(lista:list[FrecuenciaNombre], año:int, limite:int = 10, genero:str = None) -> list[tuple[str, int]]:
    res:list = []
    lista_prdenada = sorted(lista, key=lambda x: x.frecuencia, reverse=True)
    contador:int = 0
    for e in lista_prdenada:
        if((e.genero == genero or genero == None) and e.año == año):
            res.append((e.nombre, e.frecuencia))
            contador += 1
        if(contador == limite):
            break
    return res

def calcular_nombres_ambos_generos(lista:list[FrecuenciaNombre]) -> set[str]:
    res:set = set()
    nombres_h = calcular_nombres(lista, 'Hombre')
    nombres_m = calcular_nombres(lista, 'Mujer')
    for e in lista:
        if((e.nombre in nombres_h) and (e.nombre in nombres_m)):
            res.add(e.nombre)
    return res

def calcular_nombres_compuestos(lista:list[FrecuenciaNombre], genero:str = None) -> set[str]:
    res:set = set()
    for e in lista:
        if(e.genero == genero or genero == None):
            nombre_separado:str = e.nombre.split(' ')
            if(len(nombre_separado) > 1):
                res.add(e.nombre)
    return res

def calcular_frecuencia_media_nombre_años(lista:list[FrecuenciaNombre], nombre:str, año_inicial:int, año_final:int) -> float:
    frecuencia_media:float = 0.
    frecuencia_total:int = 0
    contador:int = 0
    for e in lista:
        if(e.nombre == nombre and e.año >= año_inicial and e.año <= año_final):
            frecuencia_total += e.frecuencia
            contador += 1
    if(contador > 0):
        frecuencia_media = frecuencia_total/contador
    return frecuencia_media

def calcular_nombre_mas_frecuente_año_genero(lista:list[FrecuenciaNombre], año:int, genero:str) -> str:
    nombre:str = ''
    tupla_mas_frecuente = calcular_top_nombres_de_año(lista, año, 1, genero)
    for e in tupla_mas_frecuente:
        nombre = e[0]
    return nombre

def calcular_año_mas_frecuencia_nombre(lista:list[FrecuenciaNombre], nombre:str) -> int:
    lista_nombre:list[tuple[int, int]] = ((e.año, e.frecuencia) for e in lista if e.nombre == nombre)
    maximo = max(lista_nombre, key=lambda x: x[1])
    return maximo[0]

def calcular_nombres_mas_frecuentes(lista:list[FrecuenciaNombre], genero:str, decada:int, m:int) -> list[str]:
    res:list = []
    contador:int = 0
    lista_ordenada = sorted(lista, key=lambda x: x.frecuencia, reverse=True)
    for e in lista_ordenada:
        if(e.genero == genero and e.año <= decada+10 and e.año >= decada):
            res.append(e.nombre)
            contador +=1
        if(contador == m):
            break
    return res

def calcular_año_frecuencia_por_nombre(lista:list[FrecuenciaNombre], genero:str) -> dict[str, list[tuple[int, int]]]:
    res:dict[str, list[tuple[int, int]]] = dict()
    for e in lista:
        clave:str = e.nombre
        if(clave in res.keys()):
            listado = res.get(clave)
            listado.append((e.año, e.frecuencia))
            res[clave] = listado
        else:
            listado = [(e.año, e.frecuencia)]
            res[clave] = listado
    return res

def calcular_nombre_mas_frecuente_por_año(lista:list[FrecuenciaNombre], genero:str) -> list[tuple[int, str, int]]:
    res:list = []
    lista_ordenada = sorted(lista, key= lambda x: x.año)
    años_analizados:set = set()
    for e in lista_ordenada:
        if(e.año in años_analizados):
            continue
        nombre_mas_frec = calcular_nombre_mas_frecuente_año_genero(lista_ordenada, e.año, genero)
        frec_maxima = max(lista_ordenada, key=lambda x: x.año == e.año).frecuencia
        res.append((nombre_mas_frec, e.año, frec_maxima))
        años_analizados.add(e.año)
    return res

def calcular_frecuencia_por_año(lista:list[FrecuenciaNombre], nombre:str) -> list[tuple[int, int]]:
    res:list = []
    lista_ordenada = sorted(lista, key=lambda x: x.año)
    años_analizados:set = set()
    for e in lista_ordenada:
        if(e.año in años_analizados):
            continue
        frec_maxima_nombre_año = max(lista_ordenada, key=lambda x: x.nombre == nombre and x.año == e.año).frecuencia
        res.append((e.año, frec_maxima_nombre_año))
        años_analizados.add(e.año)
    return res