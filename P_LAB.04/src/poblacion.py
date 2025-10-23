import csv
from typing import NamedTuple
from matplotlib import pyplot as plt

RegistroPoblacion = NamedTuple('RegitroPoblacion', [(
    'pais', str), ('codigo', str), ('año', int), ('censo', int)])


def lee_poblaciones(fichero) -> list[RegistroPoblacion]:
    lista_poblacion = []
    with open(fichero) as f:
        lector = csv.reader(f)
        next(lector)
        for pais, codigo, año, censo in lector:
            pais = str(pais)
            codigo = str(codigo)
            año = int(año)
            censo = int(censo)
            listado = RegistroPoblacion(pais, codigo, año, censo)
            lista_poblacion.append(listado)
    return lista_poblacion


def calcula_paises(poblacion: list[RegistroPoblacion]) -> list:
    paises_filtrados = set()
    for e in poblacion:
        paises_filtrados.add(e.pais)
    paises_ordenados = list(paises_filtrados)
    paises_ordenados.sort()
    return paises_ordenados


def filtra_por_pais(poblacion: list[RegistroPoblacion], nombre_o_codigo: str) -> list:
    info_pais_año = []
    for e in poblacion:
        if e.pais.lower() == nombre_o_codigo.lower() or e.codigo.lower() == nombre_o_codigo.lower():
            info_pais_año.append((e.año, e.censo))
    return info_pais_año


def filtra_por_paises_y_año(poblacion: list[RegistroPoblacion], año: int, paises: set) -> list:
    info_paises_año = []
    for e in poblacion:
        if e.pais in paises:
            if e.año == año:
                info_paises_año.append((e.pais, e.censo))
    return info_paises_año


def muestra_evolucion_poblacion(poblacion: list[RegistroPoblacion], nombre_o_codigo: str):
    años_registrados = []
    censo_registrado = []
    for e in poblacion:
        if e.pais.lower() == nombre_o_codigo.lower() or e.codigo.lower() == nombre_o_codigo.lower():
            años_registrados.append(e.año)
            censo_registrado.append(e.censo)
    plt.title('Evolucion de la población')
    plt.plot(años_registrados, censo_registrado)
    plt.show()


def muestra_comparativa_paises_año(poblacion: list[RegistroPoblacion], año: int, paises: set):
    paises_registrados = []
    censo_registrado = []
    for e in poblacion:
        if e.pais in paises:
            if e.año == año:
                paises_registrados.append(e.pais)
                censo_registrado.append(e.censo)
    plt.title('Comparativa de paises')
    plt.bar(paises_registrados, censo_registrado)
    plt.show()
