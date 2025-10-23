import math
import datetime

# Defina una función tal que dados tres valores devuelva cierto si el primero está
# incluido en el intervalo cerrado definido por los otros dos
def interval(ext_izq:float, punto:float, ext_der:float) -> bool:
    return ext_izq >= punto and punto <= ext_der

# Defina una función tal que dados tres valores devuelva cierto si el primer valor está
# fuera del intervalo cerrado definido por los otros dos. Haga dos versiones una desde
# cero y la segunda reusando la función del primer ejercicio
def fuera_interv1(ext_izq:float, punto:float, ext_der:float) -> bool:
    return not (ext_izq >= punto and punto <= ext_der)

def fuera_interv2(ext_izq:float, punto:float, ext_der:float) -> bool:
    return not interval(ext_izq, punto, ext_der)

# Defina una función tal que dado el radio de un círculo devuelva su área y su longitud
def area_circ(radio:float) -> tuple[float, float]:
    area:float = math.pi * radio*radio
    longitud:float = 2 * math.pi * radio
    return [area, longitud]

# Defina una función tal que dado un precio y un descuento devuelva el nuevo precio
def descuento(precio:float, descuento:float) -> float:
    return precio - precio*descuento

# Tres segmentos de longitudes a, b y c pueden constituir un triángulo si la suma de dos
# cualesquiera de ellos es mayor que el tercero (debe cumplirse para todas las parejas).
# Por ejemplo, 7, 4 y 5 sí pueden constituir un triángulo porque 4+5>7, 7+5>4 y 7+4>5,
# pero 10, 3 y 4 no, ya que 4+3<10. Implemente una función que devuelva cierto si tres
# longitudes pueden formar un triángulo
def es_triangulo(a:float, b:float, c:float) -> bool:
    res:bool = False
    if(a+b > c and b+c > a and c+a > b):
        res = True
    return res

# Tres números forman una terna pitagórica si la suma al cuadrado de dos de ellos da el
# tercero al cuadrado. Implemente una función tal que dados tres valores numéricos
# enteros devuelva cierto si los tres valores forman una terna pitagórica
def es_terna_pitagorica(a:float, b:float, c:float) -> bool:
    res:bool = False
    if(a*a+b*b > c or c*c+a*a > b or b*b+c*c > a):
        res = False
    return res

# Defina una función valor_absoluto tal que dado un número entero n devuelve su valor
# sin signo
def valor_absoluto(n:int) -> int:
    return abs(n)

# A partir de esa función definimos una función denominada triangular tal que dados
# dos números enteros m y n se define como el cociente entre el valor absoluto de n y el
# producto de los valores absolutos de n-m y m. Por ejemplo, si n=-3 y m=2 triangular de
# n y m es 3/(2x5)=0,3, si n=5 y m=-2, entonces triangular(n,m) es igual a 5/(2x7)=5/14
def triangular(m:int, n:int) -> float:
    return valor_absoluto(n)/valor_absoluto(n-m)*valor_absoluto(m)

# Defina una función tal que dado el resultado de un partido devuelva el signo de la
# quiniela
def nose() -> str:
    return "No se que es la quinela xd"

# Defina una función que dados dos números enteros devuelva si el primero es múltiplo
# del segundo
def multiplos(a:int, b:int) -> bool:
    return a%b == 0

def es_par(a:int) -> bool:
    return multiplos(a, 2)

# Defina una función que devuelva un mensaje de “buenos días”, “buenas tardes” o
# “buenas noches” en función de la hora del sistema. Para determinar la hora del
# sistema use la sentencia hora=datetime.datetime.now().time().hour
def saludo() -> str:
    hora:int = datetime.datetime.now().time().hour
    res:str = "Buenos dias"
    if(hora >= 14 and hora < 21):
        res = "Buenas tardes"
    elif(hora >= 21 and hora < 7):
        res = "Buenas noches"
    return res

# Defina una función que devuelva el número de minutos transcurridos desde el
# comienzo del día. Use las funciones hour y minute igual que en el ejercicio anterior
def minutos_dia() -> int:
    horas:int = datetime.datetime.now().time().hour
    minuto:int = datetime.datetime.now().time().minute
    return horas*60 + minuto

# Defina una función que devuelva las raíces o soluciones de una ecuación de 2º grado
# mediante una tupla de dos valores. Si las raíces son imaginarias devuelve una dupla de
# None, si hay una sola raíz devuelve la dupla con dos valores iguales
def raices(a:int, b:int, c:int) -> tuple[int, int] | None:
    x1:int = None
    x2:int = None
    if(b*b-4*a*b > 0):
        x1 = (-b + math.sqrt(b*b - 4*a*c))/2*a
        x2 = (-b - math.sqrt(b*b - 4*a*c))/2*a
    return [x1, x2]

# Defina una función que devuelva el resultado de sumar los n primeros números,
# siendo n un número entero positivo
def sumatorio(n:int) -> int:
    res:int = 0
    for i in range(0, n+1, 1):
        res = res + i
    return res

# Defina una función para calcular el factorial de un número. El factorial de un número n
# se calcula multiplicando los factores 1 x 2 x 3 x … x (n-1) x n
def factorial(n:int) -> int:
    res:int = 1
    for i in range(1, n+1, 1):
        res = res*i
    return res

# Dado un número n defina una función que lea desde teclado n números enteros y
# devuelva cuántos de ellos son pares
def n_pares(n:int) -> int:
    res:int = 0
    for i in range(0, n, 1):
        val:float = float(input("Introduzca su numero: "))
        if(es_par(val)):
            res += 1
    return res

# Dados dos números n y m defina una función que lea desde teclado n números
# enteros y devuelva la suma de los múltiplos de m
def suma_n_multiplos(n:int, m:int) -> int:
    res:int = 0
    for i in range(0, n, 1):
        val:float = float(input("Introduzca su numero: "))
        if(multiplos(val, m)):
            res += 1
    return res

# Dados dos números enteros n y m devuelva la suma de los números entre n y m
# ambos inclusive. Tenga presente que n puede ser menor que m, igual o mayor. Por
# ejemplo si la función se invoca suma_entre(5,7) devuelve 18 y si se invoca
# suma_entre(8,5) devuelve 26
def suma_entre(n:int, m:int) -> int:
    res:int = 0
    if(n < m):
        res = n
        for i in range (n+1, m+1, 1):
            res += i
    else:
        res = m
        for i in range(m+1, n+1, 1):
            res += i
    return res

# Dados dos números n y m defina una función que lea desde teclado n números
# enteros y devuelva el mínimo. Ídem para el máximo
def min_max(n:int, m:max) -> tuple[int, int]:
    min:int = 0
    max:int = 0
    for i in range(0, n, 1):
        val:int = int(input("Introduzca su numero: "))
        if(val < min):
            min = val
    for i in range(0, m, 1):
        val:int = int(input("Introduzca su numero: "))
        if(val > max):
            max = val
    return [min, max]

# Repita los ejercicios anteriores pero dividiendo el problema en dos partes. Una función
# que lea los números y los guarde en una lista y después invoque a los métodos sum,
# len, min o max a partir de la lista creada
def min_max_ext(n:int, m:int) -> tuple[int, int]:
    lista_min:list[int] = crea_lista_numeros(n)
    lista_max:list[int] = crea_lista_numeros(m)
    minimo = min(lista_min)
    maximo = max(lista_max)
    return [minimo, maximo]


def crea_lista_numeros(n:int) -> list[int]:
    res:list[int] = []
    for i in range(0, n, 1):
        valor:int = int(input("Introduzca su numero: "))
        res.append(valor)
    return res

# Para definir una función tal que dado un número entero devuelva si un número es
# primo, puede hacerse definiendo la función directamente o bien definir la función que
# devuelva si un número es compuesto y después se niegue
def es_primo(n:int, m:int) -> bool:
    res:bool = True
    for i in range(1, m, 1):
        if(n == i):
            continue
        if(multiplos(n, i)):
            res = False
            break
    return res

# Dada una cadena de caracteres que representa un número entero devuelva la suma de
# las cifras. Por ejemplo si se le da “3256” devuelve 16, si se le da “555” devuelve 15
def suma_cadena(cadena:str) -> int:
    res:int = 0
    for i in range(0, len(cadena), 1):
        res += int(cadena[i])
    return res

# Dadas dos listas de números representando dos vectores de valores numéricos,
# devuelve el producto escalar de ambos vectores. Por ejemplo si las listas son [2, 3, 1] y
# [3, 4, 7] el resultado debe ser 2x3+3x4+1x7=25. Compruebe que ambas listas son de la
# misma longitud, si no devuelva None
def prod_escalar(lista1:list[int], lista2:list[int]) -> int | None:
    res:int = 0
    if(len(lista1) != len(lista2)):
        res = None
    else:
        for i in range(0, len(lista1), 1):
            res += lista1[i]*lista2[i]
    return res

# Dado un número entero positivo devuelve una lista con sus divisores excepto el 1. Por
# ejemplo, si se le da 12, devuelve [2, 3, 4, 6]
def divisores(n:int) -> list[int]:
    res:list[int] = []
    for i in range (2, 1000, 1):
        if(multiplos(n, i)):
            res.append(i)
        elif(i > n):
            break
    return res

# Una cadena de caracteres es un palíndromo si tiene los mismos caracteres y en el
# mismo orden mirados de izquierda a derecha que de derecha a izquierda. Construya
# una función tal que dada una cadena de caracteres devuelva si es palíndromo o no.
# Pista: compare el primer carácter con el último, el segundo con el penúltimo, etc. Si
# alguna de estas comparaciones es falsa entonces la palabra no es palíndroma. Por
# ejemplo, son palíndromos “RADAR” o “RECONOCER”
def palindromo(cadena:str) -> bool:
    res:bool = False
    cadena_inv:str = invertir_cadena(cadena)
    if(cadena == cadena_inv):
        res = True
    return res

def invertir_cadena(cadena:str) -> str:
    res:str = ""
    for i in range(0, len(cadena), 1):
        char:str = cadena[i]
        res += char
    return res

# Dado un número de una lista devuelva la primera posición en la que se encuentra. Por
# ejemplo, dada la lista [3, 5, 7, 8, 2, 8, 10] si se le da 8 debe devolver 3 (su primera
# posición empezando en 0). Si el valor no estuviera devuelve None. Consulte si hay
# alguna función en Python que haga lo mismo y qué sucede si no está
def index_lista(n:int, lista:list[int]) -> int | None:
    res:int = 0
    for i in range(0, len(lista), 1):
        e:int = lista[i]
        if(e == n):
            res = i
            break
    return res

# Tenemos dos listas pareadas (del mismo tamaño) y queremos definir una función que
# devuelva una lista formada por las tuplas de los elementos de las dos listas. Por
# ejemplo, si tenemos [3, 4, 7] y [2, -1, 4] devolvemos [(3, 2), (4,-1), (7,4)]
def tupla_listas(lista1:list[int], lista2:list[int]) -> list[tuple[int]]:
    res:list[tuple[int]] = []
    for i in range(0, len(lista1), 1):
        res.append((lista1[i], lista2[i]))
    return res

# Define una función que haga el proceso inverso al del ejercicio anterior
def listas_tupla(lista:list[tuple[int]]) -> list[int]:
    res1:list[int] = []
    res2:list[int] = []
    for i in range(0, len(lista), 1):
        indice:tuple[int] = lista[i]
        res1.append(indice[0])
        res2.append(indice[1])
    return (res1, res2)

# Dada una lista de tuplas de 3 elementos, implemente una función que devuelva cierto
# si se cumple que para todas las tuplas el primer elemento es mayor que la suma del
# segundo y tercero. Por ejemplo, para [(7,2,3),(11,4,5),(4,1,1),(8,2,3)] debe devolver
# cierto porque 7 es mayor que 2+3,11>4+5, 4>1+1 y 8>2+3. Por el contrario
# [(5,2,3),(11,4,5),(4,1,1),(8,2,3)] devuelve falso porque 5 no es mayor que 2+3
def mayor_tuplas(lista:list[tuple[int]]) -> bool:
    res:bool = True
    for i in range(0, len(lista), 1):
        valores:tuple[int] = lista[i]
        if(valores[0] <= valores[1] + valores[2]):
            res = False
    return res

# Implemente una función que reciba una tupla de dos enteros distintos y devuelva 1 si
# el primer valor es mayor que el segundo y 2 en caso contrario. Reutilizando esa
# función implemente otra que reciba una lista de tuplas con los resultados de un
# partido de tenis a tres sets y debe devolver un 1 o un 2 según el ganador del partido
# sea el primer jugador o el segundo. Un partido lo gana el jugador que gane dos sets de
# los tres y un set se gana si tiene más juegos que el contrario. Por ejemplo si la lista es
# [(6,1),(4,6),(7,6)] gana el jugador 1 porque gana el primer set (6 juegos a 1) y el tercero
# (7-6). Si la lista es [(6,1),(4,6),(2,6)] gana el jugador 2 que gana el 2º y 3º set
def gana_partido(lista:list[tuple[int]]) -> int:
    res:int = 0
    sets_ganados = tupla_1_2(lista)
    cant_1:int = 0
    cant_2:int = 0
    for i in range(0, len(sets_ganados), 1):
        if(sets_ganados[i] == 1):
            cant_1 += 1
        else:
            cant_2 += 1
    if(cant_1 > cant_2):
        res = 1
    else:
        res = 2
    return res

def tupla_1_2(lista:list[tuple[int]]) -> list[int]:
    res:list[int] = []
    for i in range(0, len(lista), 1):
        valores = lista[i]
        if(valores[0] > valores[1]):
            res.append(1)
        else:
            res.append(2)
    return res

# ----------------------------------------------------------------TEST---------------------------------------------------------------------------
print(interval(0, 10, 20))
print("------------------------------------------------------------")
print(fuera_interv1(0, 10, 20))
print("------------------------------------------------------------")
print(fuera_interv2(0, 10, 20))
print("------------------------------------------------------------")
print(area_circ(10))
print("------------------------------------------------------------")
print(descuento(100, 0.25))
print("------------------------------------------------------------")
print(es_triangulo(3,4,5))
print("------------------------------------------------------------")
print(es_terna_pitagorica(5,5,50))
print("------------------------------------------------------------")
print(valor_absoluto(-20))
print("------------------------------------------------------------")
print(triangular(-10, 20))
print("------------------------------------------------------------")
print(multiplos(10,5))
print("------------------------------------------------------------")
print(es_par(6))
print("------------------------------------------------------------")
print(saludo())
print("------------------------------------------------------------")
print(minutos_dia())
print("------------------------------------------------------------")
print(raices(1,10,7))
print("------------------------------------------------------------")
print(raices(20,3,7))
print("------------------------------------------------------------")
print(sumatorio(5))
print("------------------------------------------------------------")
print(factorial(3))
print("------------------------------------------------------------")
print(factorial(5))
print("------------------------------------------------------------")
print("n_pares funciona") # print(n_pares(3)) 
print("------------------------------------------------------------")
print("suma_n_multiplos funciona") # print(suma_n_multiplos(3, 3))
print("------------------------------------------------------------")
print(suma_entre(5, 7))
print("------------------------------------------------------------")
print(suma_entre(8, 5))
print("------------------------------------------------------------")
print("min_max funciona") # print(min_max(2, 2))
print("------------------------------------------------------------")
print("min_max_ext funciona") # print(min_max_ext(2, 2))
print("------------------------------------------------------------")
print(es_primo(892361, 4000))
print("------------------------------------------------------------")
print(suma_cadena("555"))
print("------------------------------------------------------------")
print(prod_escalar([2, 3, 1], [3, 4, 7]))
print("------------------------------------------------------------")
print("divisores solo funciona con el debugger") # print(divisores(12))
print("------------------------------------------------------------")
print(palindromo("RADAR"))
print("------------------------------------------------------------")
print(index_lista(8, [3, 5, 7, 8, 2, 8, 10]))
print("------------------------------------------------------------")
print(tupla_listas([3, 4, 7], [2, -1, 4]))
print("------------------------------------------------------------")
print(listas_tupla([(3, 2), (4, -1), (7, 4)]))
print("------------------------------------------------------------")
print(mayor_tuplas([(7,2,3),(11,4,5),(4,1,1),(8,2,3)]))
print("------------------------------------------------------------")
print(mayor_tuplas([(5,2,3),(11,4,5),(4,1,1),(8,2,3)]))
print("------------------------------------------------------------")
print(gana_partido([(6,1),(4,6),(7,6)]))
