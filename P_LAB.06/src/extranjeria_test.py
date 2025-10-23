from extranjeria import *

def test_lee_datos_extranjeria():
    datos = lee_datos_extranjeria('Laboratorios\LAB.06\data\extranjeriaSevilla.csv')
    print(f'Hay {len(datos)} entradas en el registro')

def test_numero_nacionalidades_distintas():
    datos = lee_datos_extranjeria('Laboratorios\LAB.06\data\extranjeriaSevilla.csv')
    nacionalidades = numero_nacionalidades_distintas(datos)
    print(f'Hay {len(nacionalidades)} distintas')

def test_secciones_distritos_con_extranjeros_nacionalidades():
    datos = lee_datos_extranjeria('Laboratorios\LAB.06\data\extranjeriaSevilla.csv')
    paises = numero_nacionalidades_distintas(datos)
    extranjeros = secciones_distritos_con_extranjeros_nacionalidades(datos, paises)
    print(extranjeros)

def test_total_extranjeros_por_pais():
    datos = lee_datos_extranjeria('Laboratorios\LAB.06\data\extranjeriaSevilla.csv')
    diccionario = total_extranjeros_por_pais(datos)
    print(diccionario)

def test_top_n_extranjeria():
    datos = lee_datos_extranjeria('Laboratorios\LAB.06\data\extranjeriaSevilla.csv')
    lista = top_n_extranjeria(datos)

if __name__ == '__main__':
    # test_lee_datos_extranjeria()
    # test_numero_nacionalidades_distintas()
    # test_secciones_distritos_con_extranjeros_nacionalidades()
    # test_total_extranjeros_por_pais()