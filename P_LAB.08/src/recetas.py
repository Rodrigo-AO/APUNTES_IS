from typing import NamedTuple
import csv
from datetime import datetime

Ingrediente = NamedTuple('Ingrediente', [('nombre', str), ('cantidad', float), ('unidad', str)])

Receta = NamedTuple('Receta', [('denominacion', str), ('tipo', str), ('dificultad', str),
                               ('ingredientes', list[Ingrediente]), ('tiempo', int), ('calorias', int),
                               ('fecha', datetime), ('precio', float)])


def lee_recetas(ruta:str) -> list[Receta]:
    ing = list()
    with open(ruta, encoding='UTF-8') as f:
        lector = csv.reader(f, delimiter=';')
        next(lector)
        for denominacion, tipo, dificultad, ingredientes, tiempo, calorias, fecha, precio in f:
            denominacion = str(denominacion)
            tipo = str(tipo)
            dificultad = str(dificultad)
            ingredientes = parsea_ingredientes(ingredientes)
            tiempo = int(tiempo)
            calorias = int(calorias)
            fecha = datetime.strptime(fecha, '%d/%m/%Y').date()
            precio = float(precio.replace(',','.'))
            tupla = Receta(denominacion, tipo, ingredientes, tiempo, calorias, fecha, precio)
            ing.append(tupla)
    return ing


def parsea_ingredientes(ingredientes_str: str) -> list[Ingrediente]:
    ing = list()
    if len(ingredientes_str) > 0:
        lista_ing = ingredientes_str.split(',') #Separamos la cadena de texto poor sus comas
        for ingrediente_unitario in lista_ing:
            ing.append(parsea_ingrediente(ingrediente_unitario))
    return ing


def parsea_ingrediente (ingrediente_unitario: str) -> Ingrediente:
    nombre, cantidad, unidad = ingrediente_unitario.split('-')
    return Ingrediente(nombre, float(cantidad), unidad)