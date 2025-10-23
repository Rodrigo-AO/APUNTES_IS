from peliculas import *


def test_lee_peliculas():
    peliculas = lee_peliculas('Laboratorios\LAB.09\data\peliculas.csv')
    print(len(peliculas))
    print(peliculas[0])
    print(peliculas[-1])


def test_pelicula_mas_ganancias():
    peliculas = lee_peliculas('Laboratorios\LAB.09\data\peliculas.csv')
    pelicula_ganada = pelicula_mas_ganancias(peliculas, None)
    print(pelicula_ganada)


def test_media_presupuesto_por_genero():
    peliculas = lee_peliculas('Laboratorios\LAB.09\data\peliculas.csv')
    media_presupuesto = media_presupuesto_por_genero(peliculas)
    print(media_presupuesto)


def test_peliculas_por_actor():
    peliculas = lee_peliculas('Laboratorios\LAB.09\data\peliculas.csv')
    actor_pelis = peliculas_por_actor(peliculas, None, None)
    print(actor_pelis)


def test_recaudacion_total_por_año():
    peliculas = lee_peliculas('Laboratorios\LAB.09\data\peliculas.csv')
    generos = set()
    generos.add('Drama')
    generos.add('Acción')
    recaudacion_anual = recaudacion_total_por_año(peliculas, generos)
    print(recaudacion_anual)


def test_incrementos_recaudacion_por_año():
    peliculas = lee_peliculas('Laboratorios\LAB.09\data\peliculas.csv')
    generos = set()
    generos.add(None)
    # generos.add('Acción')
    incrementos = incrementos_recaudacion_por_año(peliculas, generos)
    print(incrementos)


if __name__ == '__main__':
    # test_lee_peliculas()
    # test_pelicula_mas_ganancias()
    # test_media_presupuesto_por_genero()
    # test_peliculas_por_actor()
    # test_recaudacion_total_por_año()
    test_incrementos_recaudacion_por_año()
