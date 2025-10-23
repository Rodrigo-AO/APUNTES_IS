from ejercicio1 import *


def calcla_estado_nutricional(peso: float, estatura: float) -> str:
    imc = calcula_imc(peso, estatura)
    if imc < 18.5:
        estado = "Bajo peso"
    elif 18.5 <= imc < 25:
        estado = "Normal"
    elif 25 <= imc < 30:
        estado = "Sobrepeso"
    else:
        estado = "Obesidad"
    return estado


print(calcla_estado_nutricional(peso, estatura))
