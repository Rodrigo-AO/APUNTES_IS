from piedra_papel_tijera import * #Se le pone un asterisco para que importe todas las funciones del archivo indicado

def test_ordenador_decide_jugada():
    '''
    Test para la función ordenador_decide_jugada.
    '''
    print("Testeando ordenador_decide_jugada...")
    eleccion = ordenador_decide_jugada()
    print("El ordenador eligió:", eleccion)
    print()

def test_usuario_decide_jugada():
    '''
    Test para la función usuario_decide_jugada.
    '''
    print("Testeando usuario_decide_jugada...")
    eleccion = usuario_decide_jugada()
    print("El usuario eligió:", eleccion)
    print()

def test_determina_ganador(eleccion_jugador, eleccion_ordenador):
    '''
    Test para la función determina_ganador.
    '''
    print("Testeando determina_ganador...")        
    print(f"Jugador: {eleccion_jugador} vs. Ordenador: {eleccion_ordenador}")
    resultado = determina_ganador(eleccion_jugador, eleccion_ordenador)
    print("Resultado:", resultado)
    print()

# Función principal
if __name__ == "__main__":
    # test_ordenador_decide_jugada() ya ha sido probada, probemos la otra
    # test_usuario_decide_jugada() ya ha sido probada, probemos la otra
    # test_determina_ganador("piedra", "tijeras")
    # test_determina_ganador("piedra", "papel")
    # test_determina_ganador("piedra", "piedra")
    # test_determina_ganador("tijeras", "tijeras")
    # test_determina_ganador("tijeras", "papel")
    # test_determina_ganador("tijeras", "piedra")
    # test_determina_ganador("papel", "tijeras")
    # test_determina_ganador("papel", "papel")
    # test_determina_ganador("papel", "piedra")
    jugar_torneo()
