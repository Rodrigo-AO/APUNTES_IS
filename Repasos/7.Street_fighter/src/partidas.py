from typing import NamedTuple
import csv
import datetime

Partida = NamedTuple("Partida", [("pj1", str), ("pj2", str), ("puntuacion", int), ("tiempo", float), ("fecha_hora", datetime),
    ("golpes_pj1", list[str]), ("golpes_pj2", list[str]), ("movimiento_final", str), ("combo_finish", bool), ("ganador", str)])

def lee_partidas(fichero) -> list[Partida]:
    res:list[Partida] = []
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f, delimiter=',')
        next(lector)
        for pj1, pj2, puntuacion, tiempo, fecha_hora, golpes_pj1, golpes_pj2, movimiento_final, combo_finish, ganador in lector:
            pj1:str = str(pj1)
            pj2:str = str(pj2)
            puntuacion:int = int(puntuacion)
            tiempo:float = float(tiempo)
            fecha_hora:datetime = datetime.datetime.strptime(fecha_hora, '%Y-%m-%d %H:%M:%S')
            golpes_pj1:list[str] = listado_str(golpes_pj1)
            golpes_pj2:list[str] = listado_str(golpes_pj2)
            movimiento_final:str = str(movimiento_final)
            combo_finish:bool = boolean(combo_finish)
            ganador:str = str(ganador)
            partida = Partida(pj1, pj2, puntuacion, tiempo, fecha_hora, golpes_pj1, golpes_pj2, movimiento_final, combo_finish, ganador)
            res.append(partida)
    return res

def boolean(txt:str) -> bool:
    res:bool = False
    valor = int(txt)
    if(valor == 1):
        res = True
    return res

def listado_str(txt:str) -> list[str]:
    res:list[str] = []
    values = txt.split(',')
    for e in values:
        atk = e.strip('[] ')
        res.append(atk)
    return res

def victoria_mas_rapida(lista:list[Partida]) -> tuple[tuple[str, str], datetime.time]:
    res:Partida = lista[0]
    for e in lista:
        if(e.tiempo < res.tiempo):
            res = e
    return ((res.pj1, res.pj2), res.tiempo)

def top_ratio_medio_personajes(lista:list[Partida], n:int) -> list[str]:
    ratio_aux:dict[str, tuple[int, float]] = {}
    ratio:dict[str, float] = {}
    res:list[str] = []
    for e in lista:
        clave = e.ganador
        if(clave in ratio_aux.keys()):
            valor = ratio_aux.get(clave)
            pto = valor[0] + e.puntuacion
            tmp = valor[1] + e.tiempo
            ratio_aux[clave] = (pto, tmp)
        else:
            ratio_aux[clave] = (e.puntuacion, e.tiempo)
    for clave in ratio_aux.keys():
        ratio[clave] = ratio_aux.get(clave)[0]/ratio_aux.get(clave)[1]
    ord = sorted(ratio.items(), key=lambda x: x[1])
    contador:int = 0
    for entry in ord:
        res.append(entry[0])
        contador +=1
        if(contador == n):
            break
    return res

def enemigos_mas_debiles(lista:list[Partida], personaje:str) -> tuple[list[str], int]:
    aux:dict[str, int] = {}
    dict_wins:dict[int, list[str]] = {}
    for e in lista:
        if(e.ganador == personaje):
            if(e.pj1 != personaje):
                clave = e.pj1
            else:
                clave = e.pj2
            if(clave in aux.keys()):
                valor = aux.get(clave) + 1
                aux[clave] = valor
            else:
                aux[clave] = 1
    for valor in aux.keys():
        clave = aux.get(valor)
        if(clave in dict_wins.keys()):
            pjs = dict_wins.get(clave)
            pjs.append(valor)
            dict_wins[clave] = pjs
        else:
            pjs = []
            pjs.append(valor)
            dict_wins[clave] = pjs
    ord = sorted(dict_wins.items(), key=lambda x: x[0], reverse=True)
    for e in ord:
        res = (e[1], e[0])
        break
    return res

def movimientos_comunes(lista:list[Partida], pj1:str, pj2:str) -> list[str]:
    res:list[str] = []
    movs_pj1:set[str] = set()
    movs_pj2:set[str] = set()
    for e in lista:
        if(e.pj1 == pj1):
            for mov in e.golpes_pj1:
                movs_pj1.add(mov)
        elif(e.pj2 == pj2):
            for mov in e.golpes_pj2:
                movs_pj2.add(mov)
    for mov_1 in movs_pj1:
        if(mov_1 in movs_pj2):
            res.append(mov_1)
    return res

def dia_mas_combo_finish(lista:list[Partida]) -> str:
    aux:dict[int, int] = {}
    for e in lista:
        clave = e.fecha_hora.weekday()
        if(e.combo_finish == True):
            if(clave in aux.keys()):
                valor = aux.get(clave) + 1
                aux[clave] = valor
            else:
                aux[clave] = 1
    ord = sorted(aux.items(), key=lambda x: x[1], reverse=True)
    for e in ord:
        res = e[0]
        break
    dia = dia_a_str(res)
    return dia

def dia_a_str(dia:int) -> str:
    res:str = ''
    if(dia == 1):
        res = 'Lunes'
    elif(dia == 1):
        res = 'Martes'
    elif(dia == 2):
        res = 'Miercoles'
    elif(dia == 3):
        res = 'Jueves'
    elif(dia == 4):
        res = 'Viernes'
    elif(dia == 5):
        res = 'Sábado'
    else:
        res = 'Domingo'
    return res