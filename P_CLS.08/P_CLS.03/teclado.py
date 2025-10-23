#Dado un número n defina una funcion que lea desde el teclado n numeros enteros y devuelva cuantos de ellos son pares

x = float(input("Deme su número: "))

def es_par(x:int)->bool:
    if x%2 == 0:
        par = True
    else: 
        par = False
    return par


def lee_n_numeros_pares(n:int)->int:
    contador = 0
    for i in range (n):
        x = int(input("Deme su número entero: "))
        if es_par(x): #Coje x y lo usa en es_par, la cual nos devuelve True o False, si es True "suma" un nº al contador
            contador = contador + 1
    return contador

print(lee_n_numeros_pares(5))
