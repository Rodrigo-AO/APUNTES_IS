import csv
# from collections import namedtuple
from typing import NamedTuple
from datetime import datetime
# RegistroClima = namedtuple('RegistroClima', 'fecha, lluvia, temp_max, temp_min')
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
