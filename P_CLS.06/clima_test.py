from datetime import datetime
from clima_lectura import *
from clima_funciones import *


def test_lectura():
    lista_r = leer_clima("./data/madrid-1951-2016.csv")
    print("número de registros leídos ", len(lista_r))
    print("el primer regisro es ", lista_r[0])
    print("el último registro es ", lista_r[-1])


def test_filtra_entre_fechas():
    fec1 = datetime(1985, 12, 20).date()
    fec2 = datetime(1987, 10, 26).date()
    lista_r = leer_clima("./data/madrid-1951-2016.csv")
    lista_f = filtra_entre_fechas(lista_r, fec1, fec2)
    print("número de registros leídos ", len(lista_f))
    print("el primer regisro es ", lista_f[0])
    print("el último registro es ", lista_f[-1])


def test_filtra_entre_fechas_cadenas():
    lista_r = leer_clima("./data/madrid-1951-2016.csv")
    lista_f = filtra_entre_fechas_cadenas(lista_r, "20/12/1985", "26/10/1987")
    print("número de registros leídos ", len(lista_f))
    print("el primer regisro es ", lista_f[0])
    print("el último registro es ", lista_f[-1])


def funcion_principal():
    # test_lectura()
    # test_filtra_entre_fechas()
    test_filtra_entre_fechas_cadenas()


if __name__ == "__main__":
    funcion_principal()
    '''
    test_lectura()
    test...
    test...
    '''
