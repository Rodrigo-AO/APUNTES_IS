from typing import NamedTuple
from datetime import datetime
from collections import defaultdict
import csv

Partida = NamedTuple('Partida', [('pj1', str), ('pj2', str), ('puntuacion', int), ('tiempo', float), ('fecha_hora', datetime),
                                 ('golpes_pj1', list[str]), ('golpes_pj2', list[str]), ('movimiento_final', str), ('combo_finish', bool), ('ganador', str)])

def lee_partidas(fichero: str) -> list[Partida]:
    partida = []
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f)
        next(lector)
        for pj1, pj2, puntuacion, tiempo, fecha_hora, golpes_pj1, golpes_pj2, movimiento_final, combo_finish, ganador in lector:
            pj1 = str(pj1)
            pj2 = str(pj2)
            puntuacion = int(puntuacion)
            tiempo = float(tiempo)
            fecha_hora = datetime.strptime(fecha_hora, '%Y-%m-%d %H:%M:%S').date()
            golpes_pj1 = str_a_list(golpes_pj1)
            golpes_pj2 = str_a_list(golpes_pj2)
            movimiento_final = str(movimiento_final)
            combo_finish = bool(combo_finish)
            ganador = str(ganador)
            tupla = Partida(pj1, pj2, puntuacion, tiempo, fecha_hora, golpes_pj1, golpes_pj2, movimiento_final, combo_finish, ganador)
            partida.append(tupla)
    return partida


def str_a_list(cadena_txt: str) -> list[str]:
    if len(cadena_txt) > 0:
        cadena_txt.strip()
        lista = cadena_txt.split(',')
    return lista


def victoria_mas_rapida(lista: list[Partida]) -> tuple[str, str, float]:
    speed_run = min(lista, key=lambda x: x.tiempo)
    return (speed_run.pj1, speed_run.pj2, speed_run.tiempo)


# def top_ratio_medio_personaje(lista: list[Partida], n: int) -> list[str]:
#     puntuacion = defaultdict(int)
#     tiempo = defaultdict(float)
#     ratio = defaultdict(float)
#     lista_n_ganadores = []
#     for e in lista:
#         puntuacion[e.ganador] += e.puntuacion
#         tiempo[e.ganador] += e.tiempo
#     for e in puntuacion.keys():
#         ratio[e] = puntuacion[e]/tiempo[e]
#     orden_por_ratio = sorted(ratio, key=lambda x:x[1])
#     for e in range(n):
#         lista_n_ganadores.append(orden_por_ratio[0])
#     return lista_n_ganadores

'''
Damos un personaje
Obtenemos los personajes frente a los que ha ganado (posible diccionario en el que tenemos clave el personaje y valores las veces que ha perdido)
Sorteamos el dict de mayores derrotas a menor
Usamos items para que nos de tuplas de personaje y derrotas
'''
    
def enemigos_mas_debiles(lista: list[Partida], personaje: str) -> tuple[list[str], int]:
    lista_fil = (e for e in lista if e.ganador == personaje) #Obtenemos todas las entradas en las que nuestro personaje ha ganado
    derrotas = defaultdict(int)
    for e in lista_fil:
        if e.pj1 != personaje:
            personaje_derrotado = e.pj1
        else:
            personaje_derrotado = e.pj2
        derrotas[personaje_derrotado] += 1
    derrotas_ordenadas = sorted(derrotas.items(), key=lambda x: x[1], reverse = True)
    return derrotas_ordenadas


'''
Damos 2 personajes
Analiza los movs del personaje 1 y personaje 2 (supongo que tienen movs asociados) -> crear conjunto para cada personaje?
Devuelve los que sean comunes entre los 2 -> añadimos a una lista los que estén en ambos
'''

def movimientos_comunes(lista: list[Partida], personaje1: str, personaje2: str) -> list[str]:
    movs_pj1 = set()
    movs_pj2 = set()
    for e in lista:
        if e.pj1 == personaje1:
            for movimiento1 in e.golpes_pj1:
                movs_pj1.add(movimiento1)
        elif e.pj2 == personaje2:
            for movimiento2 in e.golpes_pj2:
                movs_pj2.add(movimiento2)
    movs_comunes = []
    for mov_1 in movs_pj1:
        if mov_1 in movs_pj2:
            movs_comunes.append(mov_1)
    return movs_comunes


def dia_mas_combo_finish(lista: list[Partida]):
    lista_fil = (e for e in lista if e.combo_finish == True)
    contador_dia_combo = defaultdict()
    for e in lista_fil:
        e.fecha_hora.day = numero_dia(dia)
        contador_dia_combo[dia] += 1
    return max(contador_dia_combo.items(), key=lambda x:x[1])


