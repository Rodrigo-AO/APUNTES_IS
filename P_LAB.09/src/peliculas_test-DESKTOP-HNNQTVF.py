from peliculas import *

def test_lee_peliculas():
    peliculas = lee_peliculas('Laboratorios\LAB.09\data\peliculas.csv')
    print(peliculas)


def test_pelicula_mas_ganancias():
    peliculas = lee_peliculas('Laboratorios\LAB.09\data\peliculas.csv')
    pelicula_ganada = pelicula_mas_ganancia(peliculas, None)
    print(pelicula_ganada)


def test_media_presupuesto_por_genero():
    peliculas = lee_peliculas('Laboratorios\LAB.09\data\peliculas.csv')
    media = media_presupuesto_por_genero(peliculas)
    print(media)


def test_pelicula_por_actor():
    peliculas = lee_peliculas('Laboratorios\LAB.09\data\peliculas.csv')
    actor = pelicula_por_actor(peliculas, None, None)
    print(actor)


if __name__ == '__main__':
    # test_lee_peliculas()
    # test_pelicula_mas_ganancias()
    # test_media_presupuesto_por_genero()
    test_pelicula_por_actor()