from ejercicio2 import *


def imprime_estados_nutricionales(personas: tuple[float, float]):
    for i in range(len(personas)):
        imc_numero = calcula_imc(personas)
        imc_texto = calcla_estado_nutricional(personas)
        print("El IMC de la persona", i+1, "es de", imc_numero,
              ", y su estado nutricional es", imc_texto)


personas: tuple = [
    (60.0, 1.6),
    (75.4, 1.75),
    (87.9, 1.69),
    (45.1, 1.65)
]

print(imprime_estados_nutricionales(personas))
