from typing import NamedTuple
import csv
import datetime

Compra = NamedTuple('Compra', [('dni', str), ('supermercado', str), ('provincia', str), ('fecha_llegada', datetime),
                               ('fecha_salida', datetime), ('total_compra', float)])

def lee_compras(fichero: str):
    compra =[]
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f)
        next(lector)
        for dni, supermercado, provicia, fecha_llegada, fecha_salida, total_compra in lector:
            dni = str(dni)
            supermercado = str(supermercado)
            provicia = str(provicia)
            fecha_llegada = datetime.datetime.strptime(fecha_llegada, '%d/%m/%Y %H:%M')
            fecha_salida = datetime.datetime.strptime(fecha_salida, '%d/%m/%Y %H:%M')
            total_compra = float(total_compra)
            compra_unica = Compra[dni, supermercado, provicia, fecha_llegada, fecha_salida, total_compra]
            compra.append(compra_unica)
    return compra


def compra_maxima_minima_provincia(lista: list[Compra], provincia: str) -> tuple:
    lista_fil = (e for e in lista if provincia == e.provincia)
    if provincia in lista:
        compra_max = max(e.total_compra for e in lista_fil)
        compra_min = min(e.total_compra for e in lista_fil)
    else:
        compra_max = max(e.total_compra for e in lista)
        compra_min = min(e.total_compra for e in lista)
    compra = (compra_max, compra_min)
    return compra
