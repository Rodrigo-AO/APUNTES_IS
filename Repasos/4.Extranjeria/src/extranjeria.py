from typing import NamedTuple
import csv

RegistroExtranjeria = NamedTuple('RegistroExtranjeria', [('distrito', str), ('seccion', str), ('barrio', str),
                                                         ('pais', str), ('hombres', int), ('mujeres', int)])

def lee_datos_extranjeria(fichero) -> list[RegistroExtranjeria]:
    res:list[RegistroExtranjeria] = []
    with open(fichero, encoding='UTF-8') as f:
        lector = csv.reader(f)
        next(lector)
        for distrito, seccion, barrio, pais, hombres, mujeres in lector:
            distrito:str = str(distrito)
            seccion:str = str(seccion)
            barrio:str = str(barrio)
            pais:str = str(pais)
            hombres:int = int(hombres)
            mujeres:int = int(mujeres)
            registro = RegistroExtranjeria(distrito, seccion, barrio, pais, hombres, mujeres)
            res.append(registro)
    return res

def numero_nacionalidades_distintas(lista:list[RegistroExtranjeria]) -> int:
    nacionalidades:set = set()
    for e in lista:
        nacionalidades.add(e.pais)
    return len(nacionalidades)

def seccion_distritos_con_extranjetos_nacionalidades(lista:list[RegistroExtranjeria], paises:set[str]) -> list[tuple[str, str]]:
    secciones_distritos = []
    for e in lista:
        if(e.pais in paises):
            secciones_distritos.append((e.seccion, e.distrito))
    res = sorted(secciones_distritos, key=lambda x: x[1])
    return res

def total_extranjeros_por_pais(lista:list[RegistroExtranjeria]) -> dict[str, int]:
    res:dict = dict()
    for e in lista:
        clave:str = e.pais
        if clave in res:
            valor:int = res.get(clave)
            valor += (e.hombres + e.mujeres)
            res[clave] = valor
        else:
            valor:int = e.hombres + e.mujeres
            res[clave] = valor
    return res

def top_n_extranjeria(lista:list[RegistroExtranjeria], n:int = 3) -> list[tuple[str, int]]:
    res:list = []
    aux:list = []
    extranjeros_por_pais = total_extranjeros_por_pais(lista)
    for e in extranjeros_por_pais:
        valor:int = extranjeros_por_pais.get(e)
        res.append((e, valor))
    aux = sorted(res, key=lambda x: x[1], reverse=True)
    res.clear()
    for i in range(0, n, 1):
        res.append(aux[i])
    return res

def barrio_mas_multicultural(lista:list[RegistroExtranjeria]) -> str:
    aux:dict[str, set[str]] = dict()
    res:dict[str, int] = dict()
    for e in lista:
        clave:str = e.barrio
        if(clave in aux):
            valor = aux.get(clave)
            valor.add(e.pais)
            aux[clave] = valor
        else:
            valor = set()
            valor.add(e.pais)
            aux[clave] = valor
    for e in aux:
        res[e] = len(aux.get(e))
    return max(res.items(), key=lambda x: x[1])[0]

def barrio_con_mas_extranjeros(lista:list[RegistroExtranjeria], genero:str = None) -> str:
    res: dict[str, int] = {}
    for e in lista:
        clave = e.barrio
        if(clave in res):
            valor = res.get(clave)
            if(genero == 'Hombre'):
                valor += e.hombres
            elif(genero == 'Mujer'):
                valor += e.mujeres
            else:
                valor += (e.hombres + e.mujeres)
            res[clave] = valor
        else:
            valor:int = 0
            if(genero == 'Hombre'):
                valor += e.hombres
            elif(genero == 'Mujer'):
                valor += e.mujeres
            else:
                valor += (e.hombres + e.mujeres)
            res[clave] = valor
    return max(res.items(), key=lambda x: x[1])[0]