import random

def ordenador_decide_jugada():
    ''' 
    Elige aleatoriamente entre piedra, papel o tijeras y devuelve la elección.     
    '''
    opciones = ["piedra", "papel", "tijeras"]
    res = random.choice(opciones)
    return res

def usuario_decide_jugada():
    ''' 
    Pide al usuario que elija entre piedra, papel o tijeras y devuelve la elección.     
    '''
    eleccion_usuario = input("Elige piedra, papel o tijeras: ")
    while eleccion_usuario not in ["piedra", "papel", "tijeras"]:
        eleccion_usuario = input("Opción no válida, por favor elige piedra, papel o tijeras: ")
    return eleccion_usuario

def determina_ganador(jugada_usuario, jugada_ordenador):
    if jugada_usuario == jugada_ordenador:
        return "Empate"
    elif jugada_usuario == "piedra" and jugada_ordenador == "tijeras":
        return "Ganaste"
    elif jugada_usuario == "tijeras" and jugada_ordenador == "papel":
        return "Ganaste"
    elif  jugada_usuario == "papel" and jugada_ordenador == "piedra":
        return "Ganaste"
    else:
        return "Perdiste"
    
def jugar():
    jugada_ordenador = ordenador_decide_jugada()
    jugada_jugador = usuario_decide_jugada()
    print(f"El ordenador ha elejido... {jugada_ordenador}")
    ganador = determina_ganador(jugada_jugador, jugada_ordenador)
    # if ganador == "Ganaste":
    #     print("¡Felicidades, has ganado!")
    # elif ganador == "Perdiste":
    #     print("Lo siento, has perdido")
    # else:
    #     print("¡Empate!")
    return ganador

def jugar_torneo():
    print("Bienvenido al juego")
    puntuacion_jugador = 0
    puntuacion_ordenador = 0
    while puntuacion_jugador < 3 and puntuacion_ordenador < 3:
        ganador = jugar()
        if ganador == "Ganaste":
            print("Ronda ganada")
            puntuacion_jugador = puntuacion_jugador + 1
            print(f"Jugador {puntuacion_jugador} vs Maquina {puntuacion_ordenador}")
        elif ganador ==  "Perdiste":
            print("Ronda perdida")
            puntuacion_ordenador = puntuacion_ordenador + 1
            print(f"Jugador {puntuacion_jugador} vs Maquina {puntuacion_ordenador}")
        else:
            print("Hubo empate")
            print(f"Jugador {puntuacion_jugador} vs Maquina {puntuacion_ordenador}")
    print("El torneo ha finalizado, has...")
    if puntuacion_jugador > puntuacion_ordenador:
        print("¡Ganado!")
    else:
        print("Perdido :(")
