import csv
from typing import NamedTuple
import matplotlib as plt

FrecuenciaNombre = NamedTuple('FrecuenciaNombre', [(
    'año', int), ('nombre', str), ('frecuencia', int), ('genero', str)])


def leer_frecuencias_nombres(fichero) -> list:
    registro_nombres = []
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f)
        next(lector)
        for año, nombre, frecuencia, genero in lector:
            año = int(año)
            nombre = str(nombre)
            frecuencia = int(frecuencia)
            genero = str(genero)
            nombres = FrecuenciaNombre(año, nombre, frecuencia, genero)
            registro_nombres.append(nombres)
    return registro_nombres


def filtrar_por_genero(lista: list[FrecuenciaNombre], genero: str) -> list:
    nombres_filtrados = []
    for e in lista:
        if e.genero == genero:
            nombres_filtrados.append(e)
    return nombres_filtrados


def calcular_nombres(lista: list[FrecuenciaNombre], genero: str) -> set:
    conjunto_nombres = set()
    lista_filtrada = filtrar_por_genero(lista, genero)
    for e in lista:
        if genero == None:
            conjunto_nombres.add(e.nombre)
    for e in lista_filtrada:
        conjunto_nombres.add(e[1])
    return conjunto_nombres


def calcular_top_nombres_de_año(lista: list[FrecuenciaNombre], año: int, numero_limite: int, genero: str) -> list:
    nombres_f = []
    nombres_limite = []
    lista_filtrados = filtrar_por_genero(lista, genero)
    for e in lista:
        if genero == None and e.año == año:
            nombres_f.append((e.nombre, e.frecuencia))
    for e in lista_filtrados:
        if e[0] == año:
            nombres_f.append((e[1], e[2]))
    nombres_f.sort(key=lambda x: x[1], reverse=True)
    for i in range(numero_limite):
        nombres_limite.append(nombres_f[i])
    return nombres_limite


def calcular_nombres_ambos_generos(lista: list[FrecuenciaNombre]) -> set:
    nombres = set()
    for e in lista:
        nombres.add(e.nombre)
    return nombres


def calcular_nombres_compuestos(lista: list[FrecuenciaNombre], genero: str) -> set:
    nombres = set()
    lista_filtrada = calcular_nombres(lista, genero)
    for e in lista_filtrada:
        if ' ' in e:
            nombres.add(e)
    return nombres


def calcular_frecuencia_media_nombre_años(lista: list[FrecuenciaNombre], nombre: str, año_inicial: int, año_final: int) -> float:
    contador = 0
    frecuencias = 0
    for e in lista:
        if e.nombre == nombre.upper() and año_inicial <= e.año <= año_final:
            contador = + 1
            frecuencias = + e.frecuencia
    return (frecuencias/contador)


def calcular_nombre_mas_frecuente_año_genero(lista: list[FrecuenciaNombre], año: int, genero: str) -> str:
    lista_filtrada = calcular_top_nombres_de_año(lista, año, 1, genero)
    for e in lista_filtrada:
        nombre = e[0]
    return nombre


def calcular_año_mas_frecuencia_nombre(lista: list[FrecuenciaNombre], nombre: str) -> int:
    frecuencia = 0
    año = 0
    for e in lista:
        if e.nombre == nombre and e.frecuencia > frecuencia:
            frecuencia = e.frecuencia
            año = e.año
    return año


def calcular_nombres_mas_frecuentes(lista: list[FrecuenciaNombre], genero: str, decada: int, numero: int) -> list:
    lista_nombres = []
    for e in lista:
        if e.genero == genero and e.año in range(decada, decada + 10):
            lista_nombres.append((e.nombre, e.frecuencia))
    lista_nombres.sort(key=lambda x: x[1], reverse=True)
    lista_limitada = []
    if numero == None:
        for e in range(5):
            lista_limitada.append(lista_nombres[e])
    else:
        for e in range(numero):
            lista_limitada.append(lista_nombres[e])
    solo_nombres = []
    for e in lista_limitada:
        solo_nombres.append(e[0])
    return solo_nombres


def calcular_año_frecuencia_por_nombre(lista: list[FrecuenciaNombre], genero: str) -> dict:
    resultado = {}
    for e in lista:
        if e.nombre not in resultado and e.genero == genero:
            resultado[e.nombre] = [(e.año, e.frecuencia)]
        elif e.nombre in resultado and e.genero == genero:
            resultado[e.nombre].append((e.año, e.frecuencia))
    return resultado


def calcular_nombre_mas_frecuente_por_año(lista: list[FrecuenciaNombre], genero: str) -> list:
    entradas = []
    nombres_mas_usados_años = []
    años_usados = set()
    for e in lista:
        if e.genero == genero:
            entradas.append((e.año, e.nombre, e.frecuencia))
    entradas.sort(key=lambda x: x[2], reverse=True)
    for e in entradas:
        if e[0] not in años_usados:
            nombres_mas_usados_años.append(e)
            años_usados.add(e[0])
    nombres_mas_usados_años.sort(key=lambda x: x[0])
    return nombres_mas_usados_años


def calcular_frecuencia_por_año(lista: list[FrecuenciaNombre], nombre: str) -> list[tuple[int, int]]:
    año_frecuencia = []
    for e in lista:
        if e.nombre == nombre:
            año_frecuencia.append((e.año, e.frecuencia))
    return año_frecuencia


# def mostrar_evolucion_por_año(lista: list[FrecuenciaNombre], nombre: str):
