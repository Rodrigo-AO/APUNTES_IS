from typing import NamedTuple
from datetime import datetime
import csv

Entreno = NamedTuple('Entreno', [('tipo', str), ('fechahora', datetime), ('ubicacion', str), ('duracion', int),
                                 ('calorias', int), ('distancia', float), ('frecuencia', int), ('compartido', bool)])

def lee_entrenos(fichero) -> list:
    registro = []
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f)
        next(lector)
        for tipo, fechahora, ubicacion, duracion, calorias, distancia, frecuencia, compartido in lector:
            tipo = str(tipo)
            fechahora = datetime.strptime(fechahora, "%d/%m/%Y %H:%M")
            ubicacion = str(ubicacion)
            duracion = int(duracion)
            calorias = int(calorias)
            distancia = float(distancia)
            frecuencia = int(frecuencia)
            if compartido == 'S': compartido = True
            else: compartido = False
            registro_ciclo = Entreno (tipo, fechahora, ubicacion, duracion, calorias, distancia, frecuencia, compartido)
            registro.append(registro_ciclo)
    return registro


def tipos_entreno(lista:list[Entreno]) -> list:
    entrenos = set()
    for e in lista:
        entrenos.add(e.tipo)
    entrenos_filtrados = []
    entrenos_filtrados.append(entrenos)
    entrenos_filtrados.sort
    return entrenos_filtrados


def entrenos_duracion_superior(lista:list[Entreno], d:int) -> list:
    entrenos_filtrados = []
    for e in lista:
        if e.duracion > d:
            entrenos_filtrados.append(e)
    return entrenos_filtrados


def suma_calorias(lista:list[Entreno], f_inicio:str, f_final:str) -> int:
    suma_calorias = 0
    f_inicio = datetime.strptime(f_inicio, "%d/%m/%Y %H:%M")
    f_final = datetime.strptime(f_final, "%d/%m/%Y %H:%M")
    for e in lista:
        if f_inicio <= e.fechahora <= f_final:
            suma_calorias = suma_calorias + e.calorias
    return suma_calorias