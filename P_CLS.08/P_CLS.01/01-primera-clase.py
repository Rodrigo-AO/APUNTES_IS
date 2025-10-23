import datetime
print("Hola mundo")
# maximoValor = 23
# print(maximoValor * 3)

# maximoValor = "Hola "
# print(maximoValor * 3)

# print(maximoValor / 3)
# print(maximoValor // 3)
# print(maximoValor % 3)

def cuadrado(x: float) -> float:
    return x*x

# No hacer
# def cuadrado(x):
#   print(x*x)
# Esto tan solo lo mostrará en la consola, pero no permitirá reutilizar la función

b = 4
a = cuadrado(b*b+3-b/2) + cuadrado(b-2)
print (a)

# En todo lenguaje existen 2 bloques: las secuencias selectivas (if), que le permiten al
# código tomar diversos caminos según ciertas conciciones, y las sentencias ____ (for)

# Vamos a crear una funcion que devuelva si un valor se encuentra en un intervalo

# El () de esta_en_intervalo indica las variables que se tomarán en cuenta, y el :float no es más
# que una indicación a nivel informativo de que esa variable va a tener un valor numérico
def esta_en_intervalo(valor:float, extremo_izq:float, extremo_der:float):
    return valor >= extremo_izq and valor <= extremo_der
    # return extremo_izq <= valor <= extremo_der (Ambas son correctas, pero esta solo es válida en Python)

def no_esta_en_intervalo(valor:float, extremo_izq:float, extremo_der:float):
    return not esta_en_intervalo

#1º ejemplo de reutilizacion