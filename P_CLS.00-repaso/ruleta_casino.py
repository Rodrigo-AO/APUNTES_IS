import random
while True:
    numeros = range(1, 36)
    colores = "rojo", "negro"

    numero_maquina = random.choice(numeros)
    color_maquina = random.choice(colores)

    print(numero_maquina, color_maquina)

    n = 0
    while n == 0:

        numero_jugador = input("Escoja un número del 1 al 36: ", )
        if 1 > numero_jugador or numero_jugador > 36:
            print("Valores incorrectos, vuelva a introducirlos")
        else:
            n = n+1

    m = 0
    while m == 0:
        color_jugador = input("Escoja rojo o negro: ", )
        if color_jugador.lower() != "rojo" or "negro":
            print("Color incorrecto, vuelva a introducirlo")
        else:
            m = m+1

    print(f"Ha salido el... {numero_maquina} {color_maquina}")

    if numero_jugador == numero_maquina and color_jugador == color_maquina:
        print("Felicidades, has acertado color y número")
    elif numero_jugador == numero_maquina and color_jugador != color_maquina:
        print("Felicidades, has acertado el número")
    elif numero_jugador != numero_maquina and color_jugador == color_maquina:
        print("Felicidades, has acertado el color")
    else:
        print("No has acertado")
    volver_a_jugar = input("¿Desea volver a jugar? Si/No")
    if volver_a_jugar.lower() == "no":
        break

# Revisar porqué el código da error
