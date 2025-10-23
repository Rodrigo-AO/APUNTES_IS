# Un código que nos diga si 3 valores pueden formar un triangulo

def forman_triangulo(a:float, b:float, c:float)->bool: # Devuelve True o False
    # Debemos asegurarnos de que AL MENOS los lados a + b sean mayor que c (cateto_1 + hipotenusa > cateto_2)
    if a+b>c and b+c>a and c+a>b:
        triangulo=True
    else:
        triangulo=False
    return triangulo
# Ponemos return triangulo (la variable que hemos creado) dado que esta será la que trabaje
# con booleanos, la funcion forman_triangulo trabajará con los valores a, b y c y le hemos
# indicado que devolverá un bool

print(forman_triangulo(2, 7, 6))
