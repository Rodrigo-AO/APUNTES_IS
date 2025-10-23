from calificaciones import *

def test_nota_teoria1(lista_notas:list[float]):
    print("Test de nota_media1")
    listado:str = str(lista_notas)
    notas:str = str(nota_teoria1(lista_notas))
    print("La nota media para la lista de notas: " + listado + ", es de: " + notas)

def test_nota_teoria2(lista_notas:list[float]):
    print("Test de nota_media2")
    listado:str = str(lista_notas)
    notas:str = str(nota_teoria2(lista_notas))
    print("La nota media para la lista de notas: " + listado + ", es de: " + notas)

def test_nota_custrimestre(listado:list[float]):
    nota = nota_cuatrimestre(listado)
    print(nota)

if __name__ == "__main__":
    # test_nota_teoria1([8.2, 1.4])
    test_nota_teoria2([8.2, 1.4])
    test_nota_custrimestre([8.2, 1.4, 5])