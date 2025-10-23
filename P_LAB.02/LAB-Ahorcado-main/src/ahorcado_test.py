from ahorcado import *


def test_cargar_palabras(ruta):
    print("Testeando cargar_palabras()... ")
    palabras = cargar_palabras(ruta)
    print(f"Palabras cargadas: {len(palabras)}")
    print("Primeras 3 palabras:", palabras[:3])
    print("Últimas 3 palabras:", palabras[-3:])


def test_elegir_palabra(palabras):
    print("Testeando elegir_palabra()... ")
    palabra = elegir_palabra(palabras)
    print(f"Palabra elegida: {palabra}")


def test_enmascarar_palabra(palabra, letras_probadas):
    print(f"Testeando enmascarar_palabra() con la palabra '{
          palabra}' y las letras ({','.join(letras_probadas)})... ")
    resultado = enmascarar_palabra(palabra, letras_probadas)
    print(f"Palabra enmascarada: {resultado}")
    print()


def test_pedir_letra(letras_probadas):
    print(f"Testeando pedir_letra() con las letras ({
          ','.join(letras_probadas)})... ")
    letra = pedir_letra(letras_probadas)
    print(f"Letra introducida: {letra}")


def test_comprobar_letra(palabra, letra):
    print(f"Testeando comprobar_letra() con la palabra '{
          palabra}' y la letra '{letra}'... ")
    acierto = comprobar_letra(palabra, letra)
    print(f"Resultado: {'Acierto' if acierto else 'Fallo'}")
    print()


def test_compobar_palabra_completa(palabra, letras_probadas):
    print(f"Testeando comprobar_palabra_completa() con la palabra '{
          palabra}' y las letras ({','.join(letras_probadas)})... ")
    resultado = comprobar_palabra_completa(palabra, letras_probadas)
    print(f"Resultado: {'Completa' if resultado else 'Incompleta'}")
    print()


def test_ejecutar_turno(palabra_secreta, letras_probadas):
    print(f"Testeando ejecutar_turno() con la palabra '{
          palabra_secreta}' y las letras ({','.join(letras_probadas)})... ")
    acierto = ejecutar_turno(palabra_secreta, letras_probadas)
    print(f"Resultado: {'Acierto' if acierto else 'Fallo'}")
    print()


if __name__ == "__main__":
    # test_cargar_palabras("Python en clase\Laboratorios\LAB.02\LAB-Ahorcado-main\data\palabras_ahorcado.txt")
    # PALABRAS = cargar_palabras("Python en clase\Laboratorios\LAB.02\LAB-Ahorcado-main\data\palabras_ahorcado.txt")
    # test_elegir_palabra(PALABRAS)
    # test_enmascarar_palabra('python', {})
    # test_enmascarar_palabra('python', {'p', 'y', 't', 'h', 'o', 'n'})
    # test_enmascarar_palabra('python', {'a', 'b', 'c', 'd', 'e'})
    # test_enmascarar_palabra('python', {'a', 'e', 'i', 'o', 'u'})
    # test_pedir_letra({'a', 'b', 'c'})
    # test_comprobar_letra('python', 'p')
    # test_comprobar_letra('python', 'a')
    # test_compobar_palabra_completa('python', {'p', 'y', 't', 'h', 'o', 'n'})
    # test_compobar_palabra_completa('python', {'a', 'b', 'c', 'd', 'e'})
    # test_compobar_palabra_completa('python', {})
    test_ejecutar_turno('python', {'a', 'b', 'c', 'd', 'e'})
    test_ejecutar_turno('python', {'p', 'y', 't', 'h', 'o'})
