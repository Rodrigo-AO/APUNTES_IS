from partidas import *

partidas = lee_partidas('Repaso_convo/Repaso_laboratorios/7.Street_fighter/data/games.csv')

def test_lee_partidas():
    partidas = lee_partidas('Repaso_convo/Repaso_laboratorios/7.Street_fighter/data/games.csv')
    print(partidas)
    print('Hay', len(partidas), 'leidas')

def test_victoria_mas_rapida():
    vict = victoria_mas_rapida(partidas)
    print(vict)

def test_top_ratio_medio_personajes():
    ratio = top_ratio_medio_personajes(partidas, 2)
    print(ratio)

def test_enemigos_mas_debiles():
    enemigos = enemigos_mas_debiles(partidas, 'Ken')
    print(enemigos)

def test_movimientos_comunes():
    movs = movimientos_comunes(partidas, 'Ryu', 'Ken')
    print(movs)

def test_dia_mas_combo_finish():
    dia = dia_mas_combo_finish(partidas)
    print(dia)

if __name__ == '__main__':
    test_lee_partidas()
    test_victoria_mas_rapida()
    test_top_ratio_medio_personajes()
    test_enemigos_mas_debiles()
    test_movimientos_comunes()
    test_dia_mas_combo_finish()