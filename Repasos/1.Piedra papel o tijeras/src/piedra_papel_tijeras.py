import random

def ordenador_decide_jugada():
    opciones = ["piedra", "papel", "tijeras"]
    res = random.choice(opciones)
    return res

def usuario_decide_jugada():
    eleccion:str = str(input("Escoja entre piedra, papel o tijeras: "))
    while eleccion not in ["piedra", "papel", "tijeras"]:
        eleccion:str = str(input("Por favor, escoja piedra, papel o tijeras: "))
    return eleccion

def determina_ganador(eleccion_maquina:str, eleccion_usuario:str) -> str:
    res:str = ""
    if(eleccion_maquina == eleccion_usuario):
        res = "Empate"
    elif(eleccion_maquina=="piedra" and eleccion_usuario=="tijeras"):
        res = "Gana la maquina"
    elif(eleccion_maquina=="papel" and eleccion_usuario=="tijeras"):
        res = "Gana el usuario"
    elif(eleccion_maquina=="tijeras" and eleccion_usuario=="piedra"):
        res = "Gana el usuario"
    else:
        res = "Gana la maquina"
    return res

def jugar():
    print("Bienvenido jugador")
    eleccion_maquina=ordenador_decide_jugada()
    eleccion_usuario=usuario_decide_jugada()
    print("La eleccion de la maquina es: " + eleccion_maquina)
    print("Su elección ha sido: " + eleccion_usuario)
    partida=determina_ganador(eleccion_maquina, eleccion_usuario)
    print(partida)