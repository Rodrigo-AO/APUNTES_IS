from datetime import datetime
from clima_funciones import *
from typing import NamedTuple
import csv

RegistroClima = NamedTuple("RegistroClima", [(
    "fecha", datetime), ("lluvia", float), ("temp_max", float), ("temp_min", float)])

def leer_clima(fichero: str) -> list[RegistroClima]:
    lista_registros = []
    with open(fichero, "r") as f:
        lector = csv.reader(f)
        next(lector)  # solo si el fichero tiene una primera linea distinta
        for fecha_cadena, lluvia, tmax, tmin in lector:
            # for tupla in lector
            fecha = datetime.strptime(fecha_cadena, "%Y-%m-%d").date()
            # fecha=datetime.strptime(tupla[0],"%Y-%m-%d").date()
            lluvia = float(lluvia)
            tmax = float(tmax)
            tmin = float(tmin)
            r = RegistroClima(fecha, lluvia, tmax, tmin)
            lista_registros.append(r)
    return lista_registros


'''
1. Dadas dos fechas devuelve una lista con solo los registros entre esas
dos fechas ambas incluidas.'''


def filtra_entre_fechas(lista: list[RegistroClima], fecha1: datetime,
                        fecha2: datetime) -> list[RegistroClima]:
    lista_fil = []
    for r in lista:
        # la fecha del registro r debe estar entre fecha1 y fecha2
        if fecha1 <= r.fecha <= fecha2:  # fecha1 <= r[0] <= fecha2
            # en otros lenguajes pondríamos fecha1 <= r.fecha and r.fecha <= fecha2
            lista_fil.append(r)
        return lista_fil


'''Dadas dos cadenas de caracteres representando dos fechas con el formato “día/mes/año”
devuelve una lista con los registros entre esas dos fechas ambas incluidas.'''


def filtra_entre_fechas_cadenas(lista: list[RegistroClima], fecha1: str,
                                fecha2: str) -> list[RegistroClima]:
    f1 = datetime.strptime(fecha1, "%d/%m/%Y")
    f2 = datetime.strptime(fecha2, "%d/%m/%Y")
    return filtra_entre_fechas(lista, f1, f2)


'''Devolver el día más frio.'''


def dia_mas_frio(lista: list[RegistroClima]) -> RegistroClima:
    return min(lista, key= lambda x:x.temp_min).fecha
    # return min(lista, key=lambda x: x.temp_min) tambien x:x[3]

# si quisiera devolver solo la fecha


'''Devolver dia con mas lluvia'''


def dia_mas_lluvia(lista:list[RegistroClima]) -> RegistroClima:
    return max(lista, key=lambda x:x.lluvia).fecha


'''Dado un año, devolver el dia mas frio de ese año y la temperatura minima'''


# def dia_mas_frio_año(lista:list[RegistroClima], año:int) -> tuple[datetime, float]:
#     lista_f = [r for r in lista if r.fecha.year==año]
#     regmin = min(lista_f, key=lambda x:x.temp_min)
#     return regmin.fecha, regmin.temp_min

def dia_mas_frio_año(lista:list[RegistroClima], año:int) -> tuple[datetime, float]:
    temp_min = 1000
    fecha_min = lista[0].fecha
    for r in lista:
        if r.fecha.year == año:
            if r.temp_min<temp_min:
                temp_min = r.temp_min
                fecha_min = r.fecha
    return fecha_min, temp_min


def dia_mas_lluvia_mes(lista:list[RegistroClima], mes:int) -> tuple[datetime, float]:
    precipitacion = 0
    fecha_min = lista[0].fecha
    for r in lista:
        if r.fecha.month == mes:
            if r.lluvia > precipitacion:
                precipitacion = r.lluvia
                fecha_min = r.fecha
    return fecha_min, precipitacion

def dia_mas_lluvia_mes2(lista:list[RegistroClima], mes:int) -> tuple[datetime, float]:
    lista_f = [r for r in lista if r.fecha.month == mes]
    regmax = dia_mas_lluvia(lista_f)
    return regmax.fecha, regmax.lluvia

def lluvia_acumulado_año(lista:list[RegistroClima], año:int) -> tuple[datetime, float]:
    suma = 0
    for t in lista:
        if t.fecha.year == año:
            suma = suma + t.lluvia
    return suma

def temp_media(lista:list[RegistroClima], lista_años:list[int]) -> float | None:
    suma = 0
    contador = 0
    for t in lista:
        if t.fecha.year in lista_años:
            suma = suma + t.temp_max
            contador = contador + 1
        else:
            media = None
        media = suma/contador
    return media
