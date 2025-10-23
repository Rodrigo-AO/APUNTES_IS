from peliculas import *

peliculas = lee_peliculas('Repaso_convo/Repaso_laboratorios/6.Peliculas/data/peliculas.csv')

def test_lee_peliculas():
    peliculas = lee_peliculas('Repaso_convo/Repaso_laboratorios/6.Peliculas/data/peliculas.csv')
    print(peliculas)
    print('Hay', len(peliculas), 'leidas')

def test_pelicula_mas_ganancias():
    pelicula_max_ganancia_N = pelicula_mas_ganancias(peliculas, None)
    pelicula_max_ganancia_D = pelicula_mas_ganancias(peliculas, 'Drama')
    print(pelicula_max_ganancia_N)
    print(pelicula_max_ganancia_D)

def test_media_presupuesto_por_genero():
    genero_presupuesto_cantidad = media_presupuesto_por_genero(peliculas)
    print(genero_presupuesto_cantidad)

def test_peliculas_por_actor():
    peliculas_por_actor_dict = peliculas_por_actor(peliculas, None, None)
    print(peliculas_por_actor_dict)

def test_actores_mas_frecuentes():
    si = actores_mas_frecuentes(peliculas, 3, 2005, 2015)
    print(si)

def test_recaudacion_total_por_año():
    rec = recaudacion_total_por_año(peliculas, None)
    print(rec)

def test_incrementos_recaudacion_por_año():
    inc = incrementos_recaudacion_por_año(peliculas, None)
    print(inc)

if __name__ == '__main__':
    #test_lee_peliculas()
    #test_pelicula_mas_ganancias()
    #test_media_presupuesto_por_genero()
    #test_peliculas_por_actor()
    #test_actores_mas_frecuentes()
    #test_recaudacion_total_por_año()
    test_incrementos_recaudacion_por_año()
