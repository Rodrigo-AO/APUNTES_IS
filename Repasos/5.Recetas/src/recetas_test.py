from recetas import *

recetas = lee_recetas('Repaso_convo/Repaso_laboratorios/5.Recetas/data/recetas.csv')

def test_lee_recetas():
    recetas = lee_recetas('Repaso_convo/Repaso_laboratorios/5.Recetas/data/recetas.csv')
    print(recetas)
    print('Hay', len(recetas), 'recetas')

def test_ingredientes_en_unidad():
    ings_none = ingredientes_en_unidad(recetas, None)
    ings_gr = ingredientes_en_unidad(recetas, 'gr')
    print(ings_none)
    print(ings_gr)

def test_recetas_con_ingredientes():
    recetas_ings = recetas_con_ingredientes(recetas, {'harina', 'azúcar'})
    print(recetas_ings)

def test_receta_mas_barata():
    receta_barata = receta_mas_barata(recetas, {'Postre', 'Entrante'}, None)
    print(receta_barata)

def test_recetas_baratas_con_menos_calorias():
    recetas_cal = recetas_baratas_con_menos_calorias(recetas, 3)
    print(recetas_cal)

if __name__ == '__main__':
    test_lee_recetas()
    test_ingredientes_en_unidad()
    test_recetas_con_ingredientes()
    test_receta_mas_barata()
    test_recetas_baratas_con_menos_calorias()