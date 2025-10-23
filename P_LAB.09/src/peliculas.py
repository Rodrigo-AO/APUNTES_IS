from datetime import datetime
from typing import NamedTuple
from collections import defaultdict
from collections import Counter
import csv


Pelicula = NamedTuple('Pelicula', [("fecha_estreno", datetime), ("titulo", str), ("director", str), ("generos", list[str]),
                                   ("duracion", int), ("presupuesto", int),  ("recaudacion", int), ("reparto", list[str])])


def lee_peliculas(fichero: str) -> list[Pelicula]:
    res = []
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f, delimiter=";")
        next(lector)
        for fecha_estreno, titulo, director, generos, duracion, presupuesto, recaudacion, reparto in lector:
            fecha_estreno = datetime.strptime(fecha_estreno, "%d/%m/%Y").date()
            titulo = str(titulo)
            director = str(director)
            generos = cadena_a_lista(generos)
            generos = (e.strip() for e in generos)
            duracion = int(duracion)
            presupuesto = int(presupuesto)
            recaudacion = int(recaudacion)
            reparto = cadena_a_lista(reparto)
            reparto = (e.strip() for e in reparto)
            tupla = Pelicula(fecha_estreno, titulo, director,
                             generos, duracion, presupuesto, recaudacion, reparto)
            res.append(tupla)
    return res


def cadena_a_lista(cadena: str) -> list[str]:
    if len(cadena) > 0:
        lista = cadena.split(",")
    return lista


def pelicula_mas_ganancias(lista: list[Pelicula], genero: str | None) -> tuple[str, float]:
    lista_fil = ((e.titulo, e.recaudacion-e.presupuesto)
                 for e in lista if genero == None or genero in e.generos)
    return max(lista_fil, key=lambda x: x[1])


def media_presupuesto_por_genero(lista: list[Pelicula]) -> dict[str, float]:
    dicc_presupuesto = defaultdict(float)
    dicc_contador = defaultdict(int)
    for e in lista:
        for genero in e.generos:
            dicc_presupuesto[genero] += e.presupuesto
            dicc_contador[genero] += 1
    dicc_media = defaultdict(float)
    for genero in dicc_presupuesto.keys():
        dicc_media[genero] = dicc_presupuesto[genero]/dicc_contador[genero]
    return dicc_media


def peliculas_por_actor(lista: list[Pelicula], año_inicial: int | None, año_final: int | None) -> dict[str, int]:
    dicc_actor = defaultdict(int)
    lista_fil = ((e.titulo, e.reparto) for e in lista if año_inicial == None or año_final == None or año_inicial <= e.fecha_estreno.year <= año_final)
    for e in lista_fil:
        for actor in e[1]:
            dicc_actor[actor] += 1
    return dicc_actor


def actores_mas_frecuentes(lista: list[Pelicula], n: int, año_inicial: int | None, año_final: int | None) -> list[str]:
    actores_y_peliculas = peliculas_por_actor(lista, año_inicial, año_final)
    lista_actores_peliculas = sorted(actores_y_peliculas.items(), key=lambda x:x[1], reverse=True)
    lista_n_actores_peliculas = list()
    for e in range(n):
        lista_n_actores_peliculas.append(lista_actores_peliculas[e])
    return lista_n_actores_peliculas


def recaudacion_total_por_año(lista: list[Pelicula], generos: set[str|None]) -> dict[int, float]:
    recaudacion_anual_genero = defaultdict(int)
    for e in lista:
        if None in generos or any(genero in e.generos for genero in generos):
            recaudacion_anual_genero[e.fecha_estreno.year] += e.recaudacion
    return recaudacion_anual_genero


def incrementos_recaudacion_por_año(lista: list[Pelicula], generos: set[str|None]) -> list[int]:
    recaudacion_anual = recaudacion_total_por_año(lista, generos)
    # año_recaudacion = sorted(recaudacion_anual.items(), key=lambda x:x[0])
    lista_media_recaudaciones = list()
    for año in recaudacion_anual.keys():
        media_recaudacion = recaudacion_anual[año] - recaudacion_anual[año-1]
        lista_media_recaudaciones.append(media_recaudacion)
    return lista_media_recaudaciones
