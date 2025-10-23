from compras import *
def test_compra_maxima_minima_provincia():
    compras = lee_compras('Laboratorios\LAB.07\data\compras.csv')
    compras_prov = compra_maxima_minima_provincia(compras, 'Sevilla')
    print(compras_prov)

if __name__ == '__main__':
    test_compra_maxima_minima_provincia()