from typing import NamedTuple
from datetime import datetime
import csv

Pelicula = NamedTuple("Pelicula", [("fecha_estreno", datetime), ("titulo", str), ("director", str), ("generos", list[str]),
    ("duracion", int), ("presupuesto", int), ("recaudacion", int), ("reparto", list[str])])


def lee_peliculas(ruta: str) -> list[Pelicula]:
    peliculas = list()
    with open(ruta, encoding='UTF-8') as f:
        lector = csv.reader(f, delimiter=';')
        next(lector)
        for fecha_estreno, titulo, director, generos, duracion, presupuesto, recaudacion, reparto in lector:
            fecha_estreno = datetime.strptime(fecha_estreno, '%d/%m/%Y').date()
            titulo = str(titulo)
            director = str(director)
            generos = cadena_lista(generos)
            duracion = int(duracion)
            presupuesto = int(presupuesto)
            recaudacion = int(recaudacion)
            reparto = cadena_lista(reparto)
            tupla = Pelicula(fecha_estreno, titulo, director, generos, duracion, presupuesto, recaudacion, reparto)
            peliculas.append(tupla)
    return peliculas

def cadena_lista(cadenas_str: str) -> list[str]:
    if len(cadenas_str) > 0:
        lista_str = cadenas_str.split(',')
    return(lista_str)

def pelicula_mas_ganancias(lista: list[Pelicula], genero: str|None) -> list[str, int]:
    lista_fil = ((e.titulo, e.recaudacion) for e in lista if genero in e.generos)
    peli = list()
    if genero == None:
        for e in lista:
            peli_gana = ((e.titulo, e.recaudacion))
            peli.append(peli_gana)
    else:
        for e in lista_fil:
            peli.append(e)
    return sorted(peli, key=lambda x:x[1], reverse=True)
