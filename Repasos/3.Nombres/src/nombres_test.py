from nombres import *

listado:list[FrecuenciaNombre] = lee_frecuencias_nombres('Repaso_convo/Repaso_laboratorios/3.Nombres/data/frecuencias_nombres.csv')

def test_lee_frecuencias_nombres():
    nombres = lee_frecuencias_nombres('Repaso_convo/Repaso_laboratorios/3.Nombres/data/frecuencias_nombres.csv')
    print(nombres)

def test_filtrar_por_genero():
    lista_filtrada = filtrar_por_genero(listado, 'Hombre')
    print(lista_filtrada)

def test_calcular_nombres():
    nombres = calcular_nombres(listado, 'Mujer')
    print(nombres)

def test_calcular_top_nombres_de_año():
    nombres_top = calcular_top_nombres_de_año(listado, 2006, 5, 'Hombre')
    print(nombres_top)

def test_calcular_nombres_ambos_generos():
    nombres = calcular_nombres_ambos_generos(listado)
    print(nombres)

def test_calcular_nombres_compuestos():
    nombres = calcular_nombres_compuestos(listado, )
    print(nombres)

def test_calcular_frecuencia_media_nombre_años():
    frec_media = calcular_frecuencia_media_nombre_años(listado, 'ALEJANDRO', 2000, 2010)
    print(frec_media)

def test_calcular_nombre_mas_frecuente_año_genero():
    nombre = calcular_nombre_mas_frecuente_año_genero(listado, 2006, 'Hombre')
    print(nombre)

def test_calcular_año_mas_frecuencia_nombre():
    año = calcular_año_mas_frecuencia_nombre(listado, 'ALEJANDRO')
    print(año)

def test_calcular_nombres_mas_frecuentes():
    nombres = calcular_nombres_mas_frecuentes(listado, 'Hombre', 2000, 10)
    print(nombres)

def test_calcular_año_frecuencia_por_nombre():
    diccionario = calcular_año_frecuencia_por_nombre(listado, 'Hombre')
    print(diccionario)

def test_calcular_nombre_mas_frecuente_por_año():
    algo = calcular_nombre_mas_frecuente_por_año(listado, 'Hombre')
    print(algo)

def test_calcular_frecuencia_por_año():
    cosa = calcular_frecuencia_por_año(listado, 'ALEJANDRO')
    print(cosa)

if __name__ == '__main__':
    # test_lee_frecuencias_nombres()
    # test_filtrar_por_genero()
    # test_calcular_nombres()
    # test_calcular_top_nombres_de_año()
    # test_calcular_nombres_ambos_generos()
    # test_calcular_nombres_compuestos()
    # test_calcular_frecuencia_media_nombre_años()
    # test_calcular_nombre_mas_frecuente_año_genero()
    # test_calcular_año_mas_frecuencia_nombre()
    # test_calcular_nombres_mas_frecuentes()
    # test_calcular_año_frecuencia_por_nombre()
    # test_calcular_nombre_mas_frecuente_por_año()
    test_calcular_frecuencia_por_año()