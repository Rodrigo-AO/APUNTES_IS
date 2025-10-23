from poblacion import *


def test_lee_poblaciones():
    poblacion = lee_poblaciones(
        'Laboratorios\LAB.04\data\population.csv')
    print(f'Hay {len(poblacion)} entrada en el fichero')
    print('La primera entrada es: ', poblacion[0])
    print('La última entrada es: ', poblacion[-1])


def test_calcula_paises():
    poblacion = lee_poblaciones(
        'Laboratorios\LAB.04\data\population.csv')
    paises_ordenados = calcula_paises(poblacion)
    print(f'Hay {len(paises_ordenados)} paises registrados')
    print('En orden alfabético, el primer país registrados es: ',
          paises_ordenados[0])
    print('En orden alfabético, el primer país registrados es: ',
          paises_ordenados[-1])


def test_filtra_por_pais():
    poblacion = lee_poblaciones(
        'Laboratorios\LAB.04\data\population.csv')
    info_pais = filtra_por_pais(poblacion, 'ESP')
    print(f'Hay {len(info_pais)} entradas para el país buscado')
    print('El primer registro es: ', info_pais[0])
    print('El último registro es: ', info_pais[-1])


def test_filtra_por_paises_y_año():
    poblacion = lee_poblaciones(
        'Laboratorios\LAB.04\data\population.csv')
    info_paises = filtra_por_paises_y_año(poblacion, 2000, ('Arab World', 'Early-demographic dividend',
                                                            'East Asia & Pacific (IDA & IBRD countries)'))
    print(info_paises)
    # print(f'Hay {len(info_paises)} entradas para los paises buscados')
    # print('La primera entrada es: ', info_paises[0])
    # print('La última entrada es: ', info_paises[-1])


def test_muestra_evolucion_poblacion():
    poblacion = lee_poblaciones(
        'Laboratorios\LAB.04\data\population.csv')
    muestra_evolucion_poblacion(poblacion, 'ESP')


def test_muestra_comparativa_paises_año():
    poblacion = lee_poblaciones(
        'Laboratorios\LAB.04\data\population.csv')
    muestra_comparativa_paises_año(poblacion, 2000, ('Spain', 'France', 'Madagascar', 'Honduras', 'Costa Rica', 'Andorra',
                                   'Ukraine', 'Yemen', 'North America', 'OECD members', 'Pre-demographic dividend', 'South Asia (IDA & IBRD)'))


if __name__ == '__main__':
    test_lee_poblaciones()
    test_calcula_paises()
    test_filtra_por_pais()
    test_filtra_por_paises_y_año()
    test_muestra_evolucion_poblacion()
    test_muestra_comparativa_paises_año()
