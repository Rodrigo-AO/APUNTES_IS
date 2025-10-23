from typing import NamedTuple
import datetime
import csv

Automovil = NamedTuple('Automovil', [('matricula', str), ('marca', str), (
    'fecha', datetime), ('kilometraje', int), ('precio', float)])


def lectura(fichero) -> list:
    automovil = []
    with open(fichero,) as f:
        lector = csv.reader(f)
        next(lector)
        for matricula, marca, fecha, kilometraje, precio in lector:
            matricula = str(matricula)
            marca = str(marca)
            fecha = datetime(fecha)
            kilometraje = int(kilometraje)
            precio = float(precio)
            automovil_tuplado = Automovil(
                matricula, marca, fecha, kilometraje, precio)
            automovil.append(automovil_tuplado)
    return automovil


def marcas(automoviles: list[Automovil]) -> list:
    marcas = set()
    for e in automoviles:
        marcas.add(e.marca)
    marcas_ordenadas = list(marcas)
    marcas_ordenadas.sort(key=lambda x: len(x))
    return marcas_ordenadas


def media_kilometros(automoviles: list[Automovil], año: int) -> float | None:
    kilometros = 0
    contador = 0
    for e in automoviles:
        if e.fecha == año:
            kilometros = + e.kilometraje
            contador = + 1
    if contador == 0:
        media = None
    else:
        media = kilometros/contador
    return media


hoy = datetime.datetime.now()

print(hoy.day * 24 + hoy.hour)
