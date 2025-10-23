numero_inicial = input("Escoge un número entero inicial: ", )
numero_inicial = int(numero_inicial)

while True:
    if numero_inicial % 2 == 0:
        numero_inicial = numero_inicial / 2
        print(numero_inicial)
    else:
        numero_inicial = numero_inicial * 3 + 1
        print(numero_inicial)
