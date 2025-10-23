import math

def area_longitud_circulo(radio:float)->tuple[float,float]:
# Definimos una función (area_longitud_circulo), a la que le introducimos un valor (radio) real (float)
# (que definiremos a conveniencia más adelante) y que nos devolverá dos valores (tuple) ambos reales (float, float)

# Si al lado de el 1º float le ponemos =a un nº (radio:float=1) tomará este valor como valor por defecto
    area=math.pi*radio**2
    # La potencia tiene más precedencia que la multiplicacion, por lo que se hace antes
    longitud=math.pi*2*radio
    return area, longitud

valor_area, valor_longitud = area_longitud_circulo(2)
# Definimos 2 funciones (valor_area, valor_longitud) y les damos el valor de nuestra funcion (area_longitud_circulo)
# a la cual le asignamos que el valor de la variable que utiliza para calcular (radio) sea 2

print(valor_area)
print(valor_longitud)
