import csv
from typing import NamedTuple
import datetime

Ingrediente = NamedTuple('Ingrediente', [('nombre', str), ('cantidad', float), ('unidad', str)])

Receta = NamedTuple('Receta', [('denominacion', str), ('tipo', str), ('dificultad', str), ('ingredientes', list[Ingrediente]),
                               ('tiempo', int), ('calorias', int), ('fecha', datetime.date), ('precio', float)])

def lee_recetas(fichero) -> list[Receta]:
    res:list = []
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f, delimiter=';')
        next(lector)
        for denominacion, tipo, dificultad, ingredientes, tiempo, calorias, fecha, precio in lector:
            denominacion:str = str(denominacion)
            tipo:str = str(tipo)
            dificultad:str = str(dificultad)
            ingredientes:list[Ingrediente] = parsea_ingredientes(ingredientes)
            tiempo:int = int(tiempo)
            calorias:int = int(calorias)
            fecha:datetime.date = parsea_fecha(fecha)
            prec:str = str(precio).replace(',', '.')
            precio:float = float(prec)
            receta:Receta = Receta(denominacion, tipo, dificultad, ingredientes, tiempo, calorias, fecha, precio)
            res.append(receta)
    return res


def parsea_ingredientes(str_ings:str) -> list[Ingrediente]:
    res:list[Ingrediente] = []
    sepa:list[str] = str_ings.split(',')
    for ing in sepa:
        ingrediente:Ingrediente = parsea_ingrediente(ing)
        res.append(ingrediente)
    return res

def parsea_ingrediente(str_ing:str) -> Ingrediente:
    sepa_str_ing:list[str] = str_ing.split('-')
    if(len(sepa_str_ing) != 3):
        return []
    nombre:str = str(sepa_str_ing[0])
    cantidad:float = float(sepa_str_ing[1])
    unidad:str = str(sepa_str_ing[2])
    res:Ingrediente = Ingrediente(nombre, cantidad, unidad)
    return res

def parsea_fecha(str_fec:str) -> datetime.date:
    sepa_fech:list[str] = str_fec.split('/')
    res:datetime.date = datetime.date(int(sepa_fech[2]), int(sepa_fech[1]), int(sepa_fech[0]))
    return res

def ingredientes_en_unidad(lista:list[Receta], uds:str) -> int:
    res:set = set()
    for e in lista:
        ingrediente = e.ingredientes
        if ingrediente == [[]]:
            continue
        for i in ingrediente:
            if(uds == None):
                res.add(i.nombre)
            elif(uds == i.unidad):
                res.add(i.nombre)
    return len(res)

def recetas_con_ingredientes(lista:list[Receta], nombres:set[str]) -> list[tuple[str, int, float]]:
    res:list = []
    for e in lista:
        ings = e.ingredientes
        if ings == [[]]:
            continue
        for i in ings:
            if(i.nombre in nombres):
                res.append((e.denominacion, e.calorias, e.precio))
    return res

def receta_mas_barata(lista:list[Receta], tipos:set[str], n:int = None) -> Receta:
    lista_ord:list[Receta] = sorted(lista, key=lambda x: x.calorias)
    recetas_cal:list[Receta] = []
    recetas_tipo:list[Receta] = []
    if(n != None):
        for i in range(0, n, 1):
            recetas_cal.append(lista_ord[i])
    else:
        recetas_cal = lista_ord
    for e in recetas_cal:
        if e.tipo in tipos:
            recetas_tipo.append(e)
    return min(recetas_tipo, key=lambda x: x.precio)

def recetas_baratas_con_menos_calorias(lista:list[Receta], n:int) -> list[tuple[str, int]]:
    precio_medio:float = 0.
    for e in lista:
        precio_medio += e.precio
    precio_medio = precio_medio/len(lista)
    res:list = []
    lista_ord = sorted(lista, key=lambda x: x.calorias)
    contador:int = 0
    for e in lista_ord:
        if(e.precio < precio_medio):
            res.append((e.denominacion, e.calorias))
            contador += 1
        if(contador == n):
            break
    return res