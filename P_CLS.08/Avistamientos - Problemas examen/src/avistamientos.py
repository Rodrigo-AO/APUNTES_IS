from typing import NamedTuple
from datetime import datetime
from collections import defaultdict
from collections import Counter
import csv
import math

# Avistamiento = namedtuple('Avistamiento','fechahora, ciudad, estado, forma, duracion, comentarios, coordenadas')
# Coordenadas = namedtuple('Coordenadas', 'latitud, longitud')

'''
1. Defina dos NamedTuple Avistamiento y Coordenadas para los namedtuple dados.
'''

Coordenadas = NamedTuple('Coordenadas', [('latitud', float), ('longitud', float)])

Avistamiento = NamedTuple('Avistamientos', [('fechahora', datetime), ('ciudad', str), ('estado', str), ('forma', str),
                                            ('duracion', int), ('comentarios', str), ('coordenadas', NamedTuple)])

'''
2. Implemente una función que lea un fichero con una estructura como la descrita y
devuelva una lista de tuplas, según el namedtuple que se proporciona. 1 punto
'''

def leer_fichero(fichero: str) -> list[Avistamiento]:
    lista = []
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f)
        next(lector)
        for fechahora, ciudad, estado, forma, duracion, comentarios, coordenadas, latitud, longitud in lector:
            fechahora = datetime.strptime(fechahora, "%m/%d/%Y %H:%M")
            ciudad = str #No necesario
            estado = str #No necesario
            forma = str #No necesario
            duracion = float
            # EN CASO DE QUE UBIERA ALGÚN BOOLEANO
            # if valor == "SI":
            #     booleano = True
            # else:
            #     booleano = False
            comentarios = str #No necesario
            coordenadas = Coordenadas(float(latitud), float(longitud))
            registro = Avistamiento(fechahora, ciudad, estado, forma, duracion, comentarios, coordenadas)
            lista.append(registro)
    return lista


'''
3. Implemente una funcion tal qeu dada una fecha devuelva el numero de avistamientos
que se han producido en dicha fecha
'''

def contador_fecha(lista: list[Avistamiento], fecha: datetime.date) -> int:
    contador = 0
    for e in lista:
        if e.fechahora.date() == fecha:
            contador += 1
    return contador

'''
4. Dado un estado implemente una función que devuelva la duración total de los
avistamientos de ese estado.
'''

def duracion_total(lista: list[Avistamiento], estado: str) -> float:
    duracion = 0
    for e in lista:
        if e.estado == estado:
            duracion += e.duracion
    return duracion

'''
5. Implemente una función tal que dado un conjunto de estados devuelva el número de
formas distintas de los avistamientos observados en esos estados.
'''

def numero_formas_distintas(lista: list[Avistamiento], estados: set) -> int:
    tipos_avistamientos = set()
    for e in lista:
        if e.estado in estados and e.forma not in tipos_avistamientos:
            tipos_avistamientos.add(e.forma)
    return len(tipos_avistamientos)

'''
6. Dada una forma determinada, devuelve el avistamiento de mayor duración de entre
todos los que tienen esa forma
'''

def avistamiento_mayor_duracion(lista: list[Avistamiento], forma: str) -> float:
    duracion = 0
    for e in lista:
        if e.forma == forma and e.duracion > duracion:
            duracion == e.duracion
    return duracion

'''
7. Implemente una función tal que dado un año y una palabra devuelva el avistamiento con
el comentario más largo y la longitud de este para los avistamientos del año y que
contenga la palabra dados como argumentos
'''

def comentario_mas_largo(lista: list[Avistamiento], año: datetime.year, palabra: str) > tuple[Avistamiento, int] | None:
    lista_fil = [(e,len(e.comentarios)) for e in lista if e.fechahora.year == año and palabra in e.comentarios]
    if len(lista_fil) > 0:
        maximo = max(lista_fil[1])
    else:
        maximo = None
    return maximo

'''
8. Escriba una función distancia para el tipo Coordenadas
'''

def distancia(coord1: Coordenadas, coord2: Coordenadas) -> float:
    dif1 = (coord1.latitud - coord2.latitud)**2
    dif2 = (coord1.longitud - coord2.longitud)**2
    return math.sqrt(dif1+dif2)

'''
9. Dado un estado, implemente una función que devuelva el punto medio (longitud y latitud
media de los avistamientos de ese estado. 1 punto
'''

def punto_medio(lista: list[Avistamiento], estado: str) -> tuple[float, float] | None:
    sum_lat = 0
    sum_lon = 0
    contador = 0
    for e in lista:
        if e.estado == estado:
            sum_lat += e.coordenadas.latitud
            sum_lon += e.coordenadas.longitud
            contador += 1
    if contador > 0:
        punto_medio = (sum_lat/contador, sum_lon/contador)
    else:
        punto_medio = None
    return punto_medio

'''
10. Usando la función distancia de Coordenadas, construya una función que tiene como
entrada unas coordenadas ubicacion y un radio r y devuelve los avistamientos que se han
situado dentro de un radio r a ubicación
'''

def avistamientos_en_radio(lista: list[Avistamiento], ubicacion: Coordenadas, radio: float):
    return [e for e in lista if distancia(ubicacion, e.coordenadas)<radio]

'''
12. Implemente una función que devuelva una lista ordenada por fecha (de más reciente a
más antigua) con los avistamientos entre fecha_inicial y fecha_final (ambas inclusive). Si
fecha_inicial es None, entonces se devolverán todos los registros hasta la fecha_final. Si
fecha_final es None, entonces se devolverán todos los registros desde la fecha_inicial. Si
ambas fechas son None, se devuelve la lista de registros completa
'''

def filtra_entre_fechas(lista: list[Avistamiento], fecha_inicial: datetime.date = None, fecha_final: datetime.date = None) -> list[Avistamiento]:
    lista_fil = []
    if fecha_inicial == None and fecha_final == None:
        lista_fil = lista
    elif fecha_inicial == None:
        lista_fil = [e for e in lista if e.fechahora.date() <= fecha_final]
    elif fecha_final == None:
        lista_fil = [e for e in lista if e.fechahora.date() >= fecha_inicial]
    else:
        lista_fil = [e for e in lista if fecha_inicial <= e.fechahora.date() <= fecha_final]
    return sorted(lista_fil, key = lambda x: x.fechahora, reverse = True) #No se puede hacer return lista_fil.sort(...)


def filtra_entre_fechas2(lista: list[Avistamiento], fecha_inicial: datetime.date = None, fecha_final: datetime.date = None) -> list[Avistamiento]:
    if fecha_inicial == None:
        fecha_inicial = datetime(1700, 1, 1).date()
    if fecha_final == None:
        fecha_final = datetime(2048, 1, 1).date()
    lista_fil = [e for e in lista if fecha_inicial <= e.fechahora.date() <= fecha_final]
    return sorted(lista_fil, key = lambda x: x.fechahora, reverse = True)


'-------------------------------------------------------------------------------------------------------------------------------'


"1. Implemente una función que devuelva el número de avistamientos por año. Hágalo con los"
"tipos dict, Counter y defaultdict"

def contador_por_año_1(lista: list[Avistamiento]) -> dict[int, int]:
    dicc = {}
    for e in lista:
        clave = e.fechahora.year
        if clave in dicc:
            dicc[clave] += 1
        else:
            dicc[clave] = 1
    return dicc

#Ahora con un default_dict

def contador_por_año_2(lista: list[Avistamiento]) -> dict[int, int]:
    dicc = defaultdict
    for e in lista:
        clave = e.fechahora.year
        dicc[clave] += 1
    return dicc

#Ahora con counter

def contador_por_año_3(lista: list[Avistamiento]) -> dict[int, int]:
    return Counter(e.fechahora.year for e in lista)[0]


"2. Implemente una función que devuelva cuál es el año con más avistamientos"

def año_mas_avistamientos_1(lista: list[Avistamiento]) -> int:
    dicc = contador_por_año_1(lista)
    # dicc.items() Hace una lista del tipo (clave, valores)
    return max(dicc.items(), key = lambda x: x[1])

def año_mas_avistamientos_2(lista: list[Avistamiento]) -> int:
    dicc = contador_por_año_3(lista)
    return dicc.most_commons(1)[0][0]


"3. Dada una forma, implemente una función que devuelva el año con más avistamientos"
"de esa forma."

def año_mas_avistamientos_forma(lista: list[Avistamiento], forma: str) -> int:
    dicc_cont = Counter(e.fechahora.year for e in lista if e.forma == forma)
    return dicc_cont.most_common(1)[0][0]


"5. Implemente una función que devuelva un diccionario que relaciona cada fecha como clave"
"con el conjunto de los avistamientos de esa fecha"

def año_mas_avistamientos_por_fecha(lista: list[Avistamiento]) -> dict[datetime]:
    dicc = dict()
    for e in lista:
        clave = e.fechahora.date()
        if clave in dicc:
            dicc[clave].add(e)
        else:
            dicc[clave] = {e}

def conjunto_avistamientos_por_fecha2(lista: list[Avistamiento]) -> dict[datetime]:
    dicc = dict()
    for e in lista:
        clave = e.fechahora.date()
        dicc[clave].add(e)
    return dicc

"Cual es la fecha con mayor numero de formas de avistamientos"

def fecha_con_mayor_numero_formas(lista: list[Avistamiento]) -> datetime:
    dicc = conjunto_avistamientos_por_fecha2(Avistamiento)
    dicc_formas = dict()
    for fecha in dicc:
        formas = {e.forma for e in dicc[fecha]}
        dicc_formas[fecha] = formas
    return max(dicc_formas.items())