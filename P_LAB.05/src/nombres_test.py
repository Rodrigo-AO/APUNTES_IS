from nombres import *


def test_leer_frecuencias_nommbres():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    print(f'Hay {len(nombres)} entradas en el fichero')
    print('La primera entrada es: ', nombres[0])
    print('La última entrada es: ', nombres[-1])


def test_filtrar_por_genero():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    nombres_filtrados = filtrar_por_genero(nombres, 'Hombre')
    print(f'Hay {len(nombres_filtrados)} entradas para el género buscado')


def test_calcular_nombres():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    nombres_filtrados = calcular_nombres(nombres, 'Hombre')
    print(nombres_filtrados)


def test_calcular_top_nombres_de_año():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    nombres_filtrados = calcular_top_nombres_de_año(nombres, 2010, 10, None)
    print(nombres_filtrados)


def test_calcular_nombres_ambos_generos():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    nombres_filtrados = calcular_nombres_ambos_generos(nombres)
    print(nombres_filtrados)


def test_calcular_nombres_compuestos():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    nombres_filtrados = calcular_nombres_compuestos(nombres, 'Hombre')
    print(nombres_filtrados)


def test_calcular_frecuencia_media_nombre_años():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    frecuencia_nombres = calcular_frecuencia_media_nombre_años(
        nombres, 'Marco', 2000, 2010)
    print(f'La frecuencia media del nombre Marco desde el 2000 hasta el 2010 ha sido de {
          frecuencia_nombres}')


def test_calcular_nombre_mas_frecuente_año_genero():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    nombre_mas_frecuente = calcular_nombre_mas_frecuente_año_genero(
        nombres, 2007, 'Mujer')
    print(nombre_mas_frecuente)


def test_calcular_año_mas_frecuencia_nombre():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    nombre_mas_frecuente = calcular_año_mas_frecuencia_nombre(nombres, 'IKER')
    print(f'El nombre buscado fue más usado en {nombre_mas_frecuente}')


def test_calcular_nombres_mas_frecuentes():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    nombres_mas_frecuentes = calcular_nombres_mas_frecuentes(
        nombres, 'Hombre', 2010, 3)
    print(nombres_mas_frecuentes)


def test_calcular_año_frecuencia_por_nombre():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    frecuencia_nombres = calcular_año_frecuencia_por_nombre(nombres, 'Mujer')
    print(frecuencia_nombres)


def test_calcular_nombre_mas_frecuente_por_año():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    frecuencia_nombres = calcular_nombre_mas_frecuente_por_año(
        nombres, 'Hombre')
    print(frecuencia_nombres)


def test_calcular_frecuencia_por_año():
    nombres = leer_frecuencias_nombres(
        'Laboratorios/LAB.05/data/frecuencias_nombres.csv')
    frecuancia_años = calcular_frecuencia_por_año(
        nombres, 'MARCOS')
    print(f'Marcos: {frecuancia_años}')


if __name__ == '__main__':
    # test_leer_frecuencias_nommbres()
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
