import random


def cargar_palabras(ruta) -> list:
    '''
    Recibe la ruta de un fichero de texto que contiene una palabra por línea y devuelve
    dichas palabras en una lista.
    '''
    with open(ruta, encoding='utf-8') as f:
        res = []
        for linea in f:
            # strip() elimina los espacios en blanco y saltos de línea al principio y al final
            res.append(linea.strip())
        return res


def elegir_palabra(PALABRAS: list) -> list:
    '''
    Elige la palabra a adivinar:
    - Selecciona una palabra aleatoria de la lista 'palabras'
    - Devuelve la palabra seleccionada
    Ayuda: 
    - La función 'random.choice' del paquete 'random' recibe una lista de opciones y 
      devuelve una de ellas seleccionada aleatoriamente.
    '''
    res = []
    res.append(random.choice(PALABRAS))
    return res


def enmascarar_palabra(palabra, letras_probadas):
    '''
    Enmascarar la palabra:
    - Inicializar una lista vacía. 
    - Recorrer cada letra de la palabra, añadiendola a la lista 
      si forma parte de las letras_probadas, o añadiendo un '_' en caso contrario. 
    - Devuelve una cadena concatenando los elementos de la lista (ver 'Ayuda')
    Ayuda: 
    - Utilice el método join de las cadenas. Observe el siguiente ejemplo:
        ' '.join(['a','b','c']) # Devuelve "a b c"
    '''
    res = []
    for l in palabra:
        if l in letras_probadas:
            res.append(l)
        else:
            res.append("_")
    return ' '.join(res)


def pedir_letra(letras_probadas):
    '''
    Pedir la siguiente letra:
    - Pedirle al usuario que escriba la siguiente letra por teclado
    - Comprobar si la letra indicada ya se había propuesto antes y pedir otra si es así
    - Considerar las letras en minúsculas aunque el usuario las escriba en mayúsculas
    - Devolver la letra
    Ayuda:
    - La función 'input' permite leer una cadena de texto desde la entrada estándar
    - El método 'lower' aplicado a una cadena devuelve una copia de la cadena en minúsculas
    '''
    letra_usuario = input("Introduzca su letra: ", )
    while True:
        if letra_usuario in letras_probadas:
            letra_usuario = input(
                "La letra introducida ya ha sido solicitada. Por favor, introduzca otra letra: ", )
        else:
            break
    letra_usuario = letra_usuario.lower()
    return letra_usuario


def comprobar_letra(palabra_secreta, letra):
    '''
    Comprobar letra:
    - Comprobar si la letra está en la palabra secreta o no
    - Mostrar el mensaje correspondiente informando al usuario
    - Devolver True si estaba y False si no
    '''
    acierto = False
    if letra in palabra_secreta:
        print(f"La letra {letra} se encuentra en la palabra")
        acierto = True
    else:
        print(f"La letra {letra} no se encuentra en la palabra")
    return acierto


def comprobar_palabra_completa(palabra_secreta, letras_probadas):
    '''
    Comprobar si se ha completado la palabra:
    - Comprobar si todas las letras de la palabra secreta han sido propuestas por el usuario
    - Devolver True si es así o False si falta alguna letra por adivinar
    '''
    for no_se_porque_funciona_pero_lo_hace in palabra_secreta:
        if no_se_porque_funciona_pero_lo_hace in letras_probadas:
            acierto = True
        else:
            acierto = False
            break
    return acierto


def ejecutar_turno(palabra_secreta, letras_probadas):
    '''
    Ejecutar un turno de juego:
    - Mostrar la palabra enmascarada
    - Pedir la nueva letra
    - Comprobar si la letra está en la palabra (acierto) o no (fallo)
    - Añadir la letra al conjunto de letras probadas
    - Devolver True si la letra fue un acierto, False si fue un fallo
    Ayuda:
    - Recuerda las funciones que ya has implementado para mostrar la palabra, pedir la letra y comprobarla
    '''
    palabra_secreta = enmascarar_palabra(palabra_secreta, letras_probadas: )
    print(palabra_secreta)
    nueva_letra = input("Introduzca una nueva letra: ", )
    while True:
        if nueva_letra in letras_probadas:
            nueva_letra = input(
                "La letra ya ha sido probada. Por favor, introduzca una nueva letra: ", )
        else:
            break
