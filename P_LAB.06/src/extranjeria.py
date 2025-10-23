from typing import NamedTuple
import csv

'''
RegistroExtranjeria = namedtuple('RegistroExtranjeria', 'distrito,seccion,barrio,pais,hombres,mujeres')

'''
RegistroExtranjeria = NamedTuple('RegistroExtranjeria', [('distrito', int), ('seccion', int), ('barrio', str), ('pais', str), ('hombres', int), ('mujeres', int)])


def lee_datos_extranjeria(fichero: str) -> list:
    registro_extranjeria = []
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f)
        next(lector)
        for distrito, seccion, barrio, pais, hombres, mujeres in lector:
            distrito = int(distrito)
            seccion = int(seccion)
            barrio = str(barrio)
            pais = str(pais)
            hombres = int(hombres)
            mujeres = int(mujeres)
            registro = RegistroExtranjeria(distrito, seccion, barrio, pais, hombres, mujeres)
            registro_extranjeria.append(registro)
    return registro_extranjeria


def numero_nacionalidades_distintas(lista: list[RegistroExtranjeria]) -> set:
    nacionalidades = set()
    for e in lista:
        nacionalidades.add(e.pais)
    return nacionalidades


def secciones_distritos_con_extranjeros_nacionalidades(lista: list[RegistroExtranjeria], paises: set) -> list[tuple]:
    distrito_seccion = []
    for e in lista:
        if e.pais in paises:
            distrito_seccion.append((e.distrito, e.seccion))
    return sorted(distrito_seccion, key=lambda x: x[0])


def total_extranjeros_por_pais(lista: list[RegistroExtranjeria]) -> dict[str, int]:
    dicc = dict()
    for e in lista:
        clave = e.pais
        if clave in dicc:
            dicc[clave] += e.hombres + e.mujeres
        else:
            dicc[clave] = e.hombres + e.mujeres
    return dicc


def top_n_extranjeria(lista: list[RegistroExtranjeria], n=3) -> list:
    paises_mas_visitantes = []
    n_paises = []
    extranjeros = total_extranjeros_por_pais(lista)
    for e in extranjeros:
       paises_mas_visitantes.append(e)
    paises_mas_visitantes.sort(key = lambda x: x[1])
    for e in range(n):
        
