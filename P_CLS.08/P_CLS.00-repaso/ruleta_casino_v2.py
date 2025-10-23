import random
import os

numeros = range(1, 36)
colores = ("rojo", "negro")

while True:

    numero_maquina = int(random.choice(numeros))
    color_maquina = str(random.choice(colores))

    numero_jugador = int(input("Escoja su número del 1 al 36: ", ))

    if numero_jugador > 36 or 1 > numero_jugador:
        numero_jugador: int = input(
            "Número inválido. Por favor, escoja otro número: ", )

    if numero_jugador > 36 or 1 > numero_jugador:
        print("Tu número sigue siendo inválido")
        break

    color_jugador = str(input("Escoja entre rojo y negro: ", ))

    if color_jugador.lower() != "rojo":
        if color_jugador.lower() != "negro":
            color_jugador = str(
                input("Color inválido. Por favor, escoja otro color: ", ))

    if color_jugador.lower() != "rojo":
        if color_jugador.lower() != "negro":
            print("Tu color veulve a ser inválido")
            break

    print("La ruleta comienza a girar y...")

    print(f"Ha salido el {numero_maquina} {color_maquina}")

    if numero_jugador == numero_maquina and color_jugador.lower() == color_maquina:
        print("Felicidades, has acertado número y color")
    elif numero_jugador == numero_maquina and color_jugador.lower() != color_maquina:
        print("Felicidades, has acertado el número")
    elif numero_jugador != numero_maquina and color_jugador.lower() == color_maquina:
        print("Felicidades, has acertado el color")
    else:
        print("No has acertado")

# En este código todo va ok, hay que hacer los bucles de valores incorrectos
