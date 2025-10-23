from piedra_papel_tijeras import *

def test_ordenador_decide_jugada():
    print("Test funcion ordenador_decide_jugada")
    jugada:str = ordenador_decide_jugada()
    print("Jugada elegida: " + jugada)

def test_usuario_decide_jugada():
    print("Test funcion usuario_decide_jugada")
    jugada:str = usuario_decide_jugada()
    print("Jugada elegida: " + jugada)

def test_determina_ganador():
    print("Test funcion determina_ganador")
    eleccion_maquina:str = ordenador_decide_jugada()
    eleccion_usuario:str = usuario_decide_jugada()
    ganador:str = determina_ganador(eleccion_maquina, eleccion_usuario)
    print("Eleccion de la maquina: " + eleccion_maquina)
    print("Eleccion del usuario: " + eleccion_usuario)
    print(ganador)

if __name__ == "__main__":
    # test_ordenador_decide_jugada()
    # test_usuario_decide_jugada()
    # test_determina_ganador()
    jugar()