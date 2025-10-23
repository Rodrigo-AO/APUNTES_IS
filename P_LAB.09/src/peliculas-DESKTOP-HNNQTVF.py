from typing import NamedTuple
from datetime import datetime
from collections import defaultdict
import csv

Pelicula = NamedTuple("Pelicula", [("fecha_estreno", datetime),  ("titulo", str),  ("director", str), ("generos", list[str]),
                                   ("duracion", int), ("presupuesto", int),  ("recaudacion", int),  ("reparto", list[str])])


def lee_peliculas(fichero: str) -> list[Pelicula]:
    peliculas = list()
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f, delimiter=';')
        next(lector)
        for fecha_estreno, titulo, director, generos, duracion, presupuesto, recaudacion, reparto in lector:
            fecha_estreno = datetime.strptime(fecha_estreno, '%d/%m/%Y').date()
            titulo = str(titulo)
            director = str(director)
            generos = cadena_a_lista(generos)
            generos = [genero.strip() for genero in generos] #Para eliminar los espacios
            duracion = int(duracion)
            presupuesto = int(presupuesto)
            recaudacion = int(recaudacion)
            reparto = cadena_a_lista(reparto)
            reparto = [r.strip() for r in reparto]
            peliculas_tupla = Pelicula(fecha_estreno, titulo, director, generos, duracion, presupuesto, recaudacion, reparto)
            peliculas.append(peliculas_tupla)
    return peliculas

def cadena_a_lista(cadena_str: str) -> list[str]:
    if len(cadena_str) > 0: #Me aseguro de que haya
        cadena_str = cadena_str.split(',')
    return cadena_str


def pelicula_mas_ganancia(lista: list[Pelicula], genero: str|None) -> tuple[str, int]:
    lista_fil = [(e.titulo, e.recaudacion-e.presupuesto) for e in lista if genero == None or genero in e.generos]
    for e in lista_fil:
        mayor_ganancia = max(lista_fil, key=lambda x:x[1])
    return mayor_ganancia


def media_presupuesto_por_genero(lista: list[Pelicula]) -> dict[str, float]:
    peli_presupuesto = defaultdict(int)
    peli_contador = defaultdict(int)
    for e in lista:
        for genero in e.generos:
            peli_presupuesto[genero] += e.presupuesto
            peli_contador[genero] += 1
    media = defaultdict(float)
    for genero in peli_presupuesto:
        media[genero] = peli_presupuesto[genero]/peli_contador[genero]
    return media


def pelicula_por_actor(lista: list[Pelicula], año_inicial: int|None, año_final: int|None) -> dict[str, int]:
    lista_fil = (e for e in lista if año_inicial == None or año_final == None or año_inicial <= e.fecha_estreno.year <= año_final)
    peli_actor = defaultdict(int)
    for e in lista_fil:
        for actor in e.reparto:
            peli_actor[actor] += 1
    return peli_actor
