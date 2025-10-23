import csv
from typing import NamedTuple
import datetime

Pelicula = NamedTuple('Pelicula', [("fecha_estreno", datetime.date), ("titulo", str), ("director", str), ("generos", list[str]),
                                   ("duracion", int), ("presupuesto", int), ("recaudacion", int), ("reparto", list[str])])

def lee_peliculas(fichero:str) -> list[Pelicula]:
    res:list = []
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f, delimiter=';')
        next(lector)
        for fecha_estreno, titulo, director, generos, duracion, presupuesto, recaudacion, reparto in lector:
            fecha_estreno:datetime.date = datetime.datetime.strptime(fecha_estreno, '%d/%m/%Y').date()
            titulo:str = str(titulo)
            director:str = str(director)
            generos:list[str] = a_lista(generos)
            duracion:int = int(duracion)
            presupuesto:int = int(presupuesto)
            recaudacion:int = int(recaudacion)
            reparto:list[str] = a_lista(reparto)
            pelicula = Pelicula(fecha_estreno, titulo, director, generos, duracion, presupuesto, recaudacion, reparto)
            res.append(pelicula)
    return res

def a_lista(texto:str) -> list[str]:
    res:list = []
    for txt in texto.split(','):
        res.append(txt.strip())
    return res

def pelicula_mas_ganancias(lista:list[Pelicula], genero:str = None) -> tuple[str, int]:
    res:Pelicula = None
    for p in lista:
        if(genero == None):
            if(res == None or (p.recaudacion - p.presupuesto) > (res.recaudacion - res.presupuesto)):
                res = p
        elif(genero in p.generos):
            if(res == None or (p.recaudacion - p.presupuesto) > (res.recaudacion - res.presupuesto)):
                res = p
    return (res.titulo, (res.recaudacion - res.presupuesto))

def media_presupuesto_por_genero(lista:list[Pelicula]) -> dict[str,float]:
    res:dict[str, float] = {}
    aux:dict[str, list[int]] = {}
    for p in lista:
        for clave in p.generos:
            if(clave in aux.keys()):
                valor = aux.get(clave)
                valor.append(p.presupuesto)
                aux[clave] = valor
            else:
                valor = []
                valor.append(p.presupuesto)
                aux[clave] = valor
    for clave in aux.keys():
        res[clave] = (sum(aux.get(clave))/(len(aux.get(clave))))
    return res

def peliculas_por_actor(lista:list[Pelicula], año_ini:int = None, año_fin:int = None) -> dict[str, int]:
    res:dict[str, int] = {}
    for p in lista:
        if((año_ini == None or año_fin == None) or (año_ini < p.fecha_estreno.year and p.fecha_estreno.year < año_fin)):
            for clave in p.reparto:
                if(clave in res.keys()):
                    valor = res.get(clave)
                    valor += 1
                    res[clave] = valor
                else:
                    valor:int = 1
                    res[clave] = valor
    return res

def actores_mas_frecuentes(lista:list[Pelicula], n:int, año_ini:int = None, año_fin:int = None) -> list[str]:
    res_no_ord:list[str] = []
    contador:int = 0
    peliculas_cada_actor = peliculas_por_actor(lista, año_ini, año_fin)
    aux = sorted(peliculas_cada_actor.items(), key=lambda x: x[1], reverse=True)
    for e in aux:
        res_no_ord.append(e[0])
        contador += 1
        if(contador == n): break
    res = sorted(res_no_ord)
    return res

def recaudacion_total_por_año(lista:list[Pelicula], generos:set[str] = None) -> dict[int, int]:
    res:dict[int, int] = {}
    for e in lista:
        for genero in e.generos:
            if(generos == None or genero in generos):
                clave:int = e.fecha_estreno.year
                if(clave in res.keys()):
                    valor = res.get(clave)
                    valor += e.recaudacion
                    res[clave] = valor
                else:
                    valor:int = e.recaudacion
                    res[clave] = valor
            break
    return res

def incrementos_recaudacion_por_año(lista:list[Pelicula], generos:set[str]) -> list[int]:
    res:list = []
    rec_año = sorted(recaudacion_total_por_año(lista, generos).items())
    for tup in rec_año:
        if(res == []):
            res.append(tup[1])
            tup_prev = tup
        else:
            res.append(tup[1] - tup_prev[1])
            tup_prev = tup
    return res