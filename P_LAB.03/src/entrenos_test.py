from entrenos import *

def test_lee_entrenos():
    entrenos = lee_entrenos('Laboratorios\LAB.03\data\entrenos.csv')
    print(f"Hay {len(entrenos)} entredas en el fichero")
    print('Las 3 primeras entradas son: ', entrenos[3])
    print('Las 3 últimas entradas son: ', entrenos[-3])

def test_tipos_entreno():
    entrenos = lee_entrenos('Laboratorios\LAB.03\data\entrenos.csv')
    entrenos_filtrados = tipos_entreno(entrenos)
    print(entrenos_filtrados)

def test_entrenos_duracion_superior():
    entrenos = lee_entrenos('Laboratorios\LAB.03\data\entrenos.csv')
    entrenos_filtrados_1 = entrenos_duracion_superior(entrenos, 100)
    print('Los entrenos de duración superior 100 minutos son: ', entrenos_filtrados_1)
    entrenos_filtrados_2 = entrenos_duracion_superior(entrenos, 120)
    print(f'De los cuales solo {len(entrenos_filtrados_2)} superan una duracion igual o superior a 120 minutos')

def test_suma_calorias():
    entrenos = lee_entrenos('Laboratorios\LAB.03\data\entrenos.csv')
    fecha_1 = '01/01/2020 16:00'
    fecha_2 = '17/11/2022 21:00'
    calorias = suma_calorias(entrenos, fecha_1, fecha_2)
    print(f"En los entrenos realizados entre el {fecha_1} y {fecha_2} se han quemado: {calorias}")


if __name__ == '__main__':
    test_lee_entrenos()
    test_tipos_entreno()
    test_entrenos_duracion_superior()
    test_suma_calorias()