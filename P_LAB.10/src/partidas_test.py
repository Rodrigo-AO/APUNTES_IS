from partidas import *


def test_lee_partidas():
    partidas = lee_partidas('Laboratorios\LAB.10\data\games.csv')
    print(partidas)


def test_victoria_mas_rapida():
    partidas = lee_partidas('Laboratorios\LAB.10\data\games.csv')
    partida_mas_rapida = victoria_mas_rapida(partidas)
    print(partida_mas_rapida)


# def test_top_ratio_medio_personaje():
#     partidas = lee_partidas('Laboratorios\LAB.10\data\games.csv')
#     ratio = top_ratio_medio_personaje(partidas, 5)
#     print(ratio)


def test_enemigos_mas_debiles():
    partidas = lee_partidas('Laboratorios\LAB.10\data\games.csv')
    personajes_debiles = enemigos_mas_debiles(partidas, 'Ken')
    print(personajes_debiles)


def test_movimientos_comunes():
    partidas = lee_partidas('Laboratorios\LAB.10\data\games.csv')
    movs_comunes = movimientos_comunes(partidas, 'Ryu', 'Ken')
    print(movs_comunes)


if __name__ == '__main__':
    test_lee_partidas()
    # test_victoria_mas_rapida()
    # test_top_ratio_medio_personaje()
    # test_enemigos_mas_debiles()
    # test_movimientos_comunes()