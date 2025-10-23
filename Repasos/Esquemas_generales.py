# Comprobar que un número esté en un intervalo
def esta_en_intervalo(valor: float, extremo_izq: float, extremo_der: float) -> bool:
    return extremo_izq <= valor and valor >= extremo_der

# Comprobar que un número no esté en un intervalo


def no_esta_en_intervalo_1(valor: float, extremo_izq: float, extremo_der: float) -> bool:
    return extremo_izq > valor or valor > extremo_der

# También se podría hacer negando la funcion esta_en_intervalo y asi la reutilizamos


def no_esta_en_intervalo_2(valor: float, extremo_izq: float, extremo_der: float) -> bool:
    return not esta_en_intervalo(valor, extremo_izq, extremo_der)

# Valor absoluto


def v_abs(n: int) -> int:
    valor = n
    if n < 0:
        valor = -n
    # else:
    #     valor = n --> No es necesario ya que hemos definido valor = n antes del if
    return valor

# Es multiplo


def es_multiplo(n: int, m: int) -> bool:
    valor = False
    if n % m == 0:
        valor = True
    # else:
    #     valor = False
    return valor

# Es par, recurrimos a la funcion es multiplo, definiendo m como 2 ya que si nos devuelve True es que el multiplo era multiplo de 2, siendo así par


def es_par(n: int) -> bool:
    return es_multiplo(n, 2)

# Funcion que recorra un rango y vaya sumando los números


def suma_n_primeros(n: int) -> int:
    suma = 0
    for i in range(1, n+1):
        # print(i, suma) -> con esto podríamos ver el valor de i y el valor de la suma en cada vuelta que da en el bucle
        suma = suma + i
    return suma


# Función similar a la anterior (que recorra un rango) pero que devuelva cuantos de ellos eran pares
# También haremos una con la misma función pero que nos diga que numeros de un rango n son multiplos de m

def lee_n_pares(n: int) -> int:
    contador = 0
    for i in range(n):
        if es_par(i):
            contador = contador + 1
    return contador


def lee_n_multiplos(n: int, m: int) -> int:
    contador = 0
    for i in range(n):
        if es_multiplo(i, m):
            contador = contador + 1
    return contador


# Podemos reciclar el anterior código para crear una suma de todos aquellos numeros pares del rango
# Así como una que sume los multiplos de un numero m


def suma_n_pares(n: int, m: int) -> int:
    suma = 0
    for i in range(n):
        # m sería el número que cambiaríamos para que cada vuelta evalua si i es multiplo de m
        if es_multiplo(i, m):
            suma = suma + i
    return suma


def suma_n_multiplos(n: int, m: int) -> int:
    multiplo = 0
    for i in range(n):
        if es_multiplo(i, m):
            multiplo = multiplo + i
    return multiplo


# Podemos crear una función que sume los números en un rango delimitado, que no empiece desde 0


def suma_rango_limitado(n: int, m: int) -> int:
    suma = 0
    if n >= m:
        for i in range(m, n):
            suma = suma + i
    else:
        for i in range(n, m):
            suma = suma + i
    return suma

# Creamos una función que haga una lista de un rango de valores


def crea_lista_numeros(n: int) -> list[int]:
    lista = []
    for i in range(n):
        lista.append(i)
    return lista

# Ahora, la lista generada la podemos usar con diferentes funciones
# Tratemos de, juntándola con la de es_par, crear una función que nos diga cuantos numeros pares hay en una lista


def suma_n_pares_lista(n: int) -> int:
    pares = 0
    for i in range(lee_n_pares(n)):
        if es_par:
            pares = pares + 1
    return pares


def suma_n_multiplos_lista(n: int, m: int) -> int:
    multiplos = 0
    for i in range(lee_n_multiplos(n)):
        if es_multiplo(i, m):
            multiplos = multiplos + i
    return multiplos


# Al final no hemos juntado las funciones, sino que hemos hecho lo mismo que las funciones suma_n_pares y suma_n_multiplos, ya que no emplean ninguna lista
# Definamos ahora una función que nos diga si un numero es primo. Para esto, crearemos primero una que nos diga si es compuesto

def es_compuesto(n: int) -> bool:
    existe = False
    for i in range(2, n):  # Ponemos en el rango (1, n) ya que sino al inicio el i = 0 causaría un error al dividir y i = 0 causaría un True para cualquier numero
        if es_multiplo(n, i):
            existe = True
    return existe


def es_primo(n: int) -> bool:
    return not es_compuesto(n)


# Ahora comenzaremos a trabajar con listas (list)
# Hagamos una función que haga el producto escalar de dos vectores. La funcion tiene que comprobar que ambas listas (vectores) estén completos, sino, que devuelva None

def producto_escalar(lista_1: list[int], lista_2: list[int]) -> int | None:
    producto = 0
    if len(lista_1) == len(lista_2):
        for i in range(len(lista_1)):
            producto = producto + lista_1[i] * lista_2[i]
    else:
        producto = None
    return producto

# Hagamos una función que nos devuelva una lista con todos los divisores de un numero
# Recurriremos a la función es_multiplo


def divisores(n: int) -> list[int]:
    div: list = []
    for i in range(2, n):
        if es_multiplo(n, i):
            div.append(i)
    return div


# El código de abajo es una forma sencilla de ver la funcionalidad del x for x in __


# i recorre del 0 al 11 tomando valores de 2 en 2 que se almacenan formando lista1
lista1 = [i for i in range(0, 11, 2)]
# i va a ir adoptando los valores que haya en lista1=[0,2,4,6,8,10], creando una lista de tuplas en lista2
lista2 = [(i, i+1) for i in lista1]
print(lista1)
print(lista2)
print(sum((y for _, y in lista2)))
'''
En lista 2 por cada posicion habra 2 valores, los de la tupla, a los que podemos llamar x,y --- albaricoques,arroz --- etc
Al escribir un sumatorio asi, lo que le indicamos es q a el valor y, que con el for le decimos que es el 2º valor de cada tupla de lista 2, los sume
A su vez, al poner el for _,y es lo mismo que decirle for x,y in lista2 (que seria decir ambos valores de cada tupla) pero que ignore la x, de ahi el _
'''


lista = [2, 3, 1, 0]
for i in lista:
    print(sum(x for x in lista[i:]))
